import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class LabTable_Skel {
    static String[] names = { "phy", "chem", "bio", "math", "stat", "com", "kdai" };
    static ArrayList<String> name_lis = new ArrayList<>(Arrays.asList(names));
    static String[] matches = new String[21];
    // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21
    static String results_str = "1:2 ,2:0 ,0:0 ,0:1 ,1:2 ,2:2 ,3:2 ,0:1 ,3:3 ,3:0 ,2:0 ,1:0 ,1:0 ,2:3 ,0:0 ,3:1 ,0:0 ,1:2 ,0:0 ,1:0 ,1:0";
    static String[] results = results_str.split(",");
    static final int WIN = 3;
    static final int LOSE = 0;
    static final int DRAW = 1;
    static {
        StringBuilder sb = new StringBuilder();
        for (int team_i = 0; team_i < names.length - 1; team_i++)
            for (int team_j = team_i + 1; team_j < names.length; team_j++)
                sb.append(names[team_i] + " vs " + names[team_j] + ";");
        String a_String = sb.toString();
        String[] tmp = a_String.split(";");
        for (int i = 0; i < matches.length; i++) {
            matches[i] = tmp[i].trim();
        }
    }

    static void byList() {
        ArrayList<Team> lis = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            lis.add(new Team(names[i]));
        }
        int match_num = 0;
        int score1, score2;
        Team team1, team2;

        //code//
        for (String i : results) {
            String[] parts = i.trim().split(":");
            score1 = Integer.parseInt(parts[0]);
            score2 = Integer.parseInt(parts[1]);

            String[] teams = matches[match_num].split(" vs ");
            team1 = lis.get(name_lis.indexOf(teams[0]));
            team2 = lis.get(name_lis.indexOf(teams[1]));

            if (score1 > score2) {
                team1.accumulate_match_stat(score1, score2, WIN);
                team2.accumulate_match_stat(score2, score1, LOSE);
            } else if (score2 > score1) {
                team2.accumulate_match_stat(score2, score1, WIN);
                team1.accumulate_match_stat(score1, score2, LOSE);
            } else {
                team1.accumulate_match_stat(score1, score2, DRAW);
                team2.accumulate_match_stat(score2, score1, DRAW);
            }

            match_num++;

        }
        //code//
        Comparator<Team> engine = new Comparator<Team>() {
            public int compare(Team t1, Team t2) {
                //code//
                if(t1.getPoints() != t2.getPoints())
                    return t1.getPoints() - t2.getPoints();
                else if(t1.getGoalsDiff() != t2.getGoalsDiff())
                    return t1.getGoalsDiff() - t2.getGoalsDiff();
                return t1.getGoalsFor() - t2.getGoalsFor(); 
                // int comP = Integer.compare(t1.getPoints(), t2.getPoints());
                // if(comP != 0){
                //     return comP ;
                // }
                // return t1.getName().compareTo(t2.getName());
                //code//
            }
        };
        Collections.sort(lis, engine);
        Collections.reverse(lis);
        for (Team t : lis) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        byList();
        // System.out.println("--x-----");
        // byMap();
    }

    static void byMap() {
        HashMap<String, Team> hm = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            hm.putIfAbsent(names[i], new Team(names[i]));
        }
        ArrayList<Team> lis = new ArrayList<>();
        lis.addAll(hm.values());
    }
}

class Team {
    String dept;
    int num_games;
    int goal_for;
    int goal_against;
    int points;

    public Team(String d) {
        dept = d;
    }

    public String getName() {
        return dept;
    }

    public int getGoalsFor() {
        return goal_for;
    }

    public int getPoints() {
        return points;
    }

    public int getGoalsDiff() {
        return goal_for - goal_against;
    }

    void accumulate_match_stat(int gf, int ga, int p) {
        num_games++;
        goal_for += gf;
        goal_against += ga;
        points += p;
    }

    public String toString() {
        return dept + "\t" + num_games + "\t" + goal_for + "\t" + goal_against + "\t" + points;
    }
}
