
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Lab10_MovieCounter {
    ArrayList<CSMovie> mList = new ArrayList<>();
    Set<String> uniqueTitle = new HashSet<>();
    String row;
    int rowCount = 1;
    int incompleteCount = 0;

    void q1() {
        double averageScore = mList.stream().mapToDouble(e -> e.getScore()).average().getAsDouble();
        System.out.println("Average Score : " + averageScore);
    }

    void q2() {
        mList.stream().filter(x-> x.getVotes() > 1_900_000).map(x -> x).forEach(movie -> System.out.println("Vote > 1_900_000 : " + movie.getVotes()));
    }

    void q3() {
        Optional<CSMovie> arr = mList.stream().max(Comparator.comparing(CSMovie::getGross));
            System.out.println("MaxGross : " + arr);
        
    }

    void q4() {
        List <String> genreList = mList.stream().map(x->x.getGenre()).distinct().collect(Collectors.toList());
        System.out.println("getGenre : " + genreList);
    }

    void q5() {
        mList.stream().sorted(Comparator.comparing(CSMovie::getGenre)).limit(5).map(e -> String.format("%-55s --> %s",e.getTitle(), e.getRuntime())).collect(Collectors.toList()).forEach(System.out::println);;
        // System.out.println("Top 5 movies with the shortest runtime : ");
        // result.forEach(System.out::println);
    }

    void q6() {
        Optional<CSMovie> maxBudgetMovie = mList.stream().max(Comparator.comparing(CSMovie::getBudget));
        Optional<CSMovie> minBudgetMovie = mList.stream().min(Comparator.comparing(CSMovie::getBudget));
        System.out.println("MaxBudgetMovie  " + "\nTitle : " + maxBudgetMovie.get().getTitle() + "\nBudget : "
                + maxBudgetMovie.get().getBudget());
        System.out.println("MaxBudgetMovie  " + "\nTitle : " + minBudgetMovie.get().getTitle() + "\nBudget : "
                + minBudgetMovie.get().getBudget());

    }

    void q7() {
       mList.stream().sorted(Comparator.comparing(CSMovie::getGenre).reversed()).limit(3).forEach(System.out::println);
    }

    void q8() {
         mList.stream()
                .filter(movie -> "Action".equalsIgnoreCase(movie.getGenre()))
                .sorted(Comparator.comparing(CSMovie::getScore).reversed().thenComparing(CSMovie::getTitle))
                .limit(3).forEach(System.out::println);

    }

    void q9() {
        Map<String, List<CSMovie>> movie_genre = mList.stream().collect(Collectors.groupingBy(CSMovie::getGenre));
        for (String genre : movie_genre.keySet()) {
            Long total_gross = movie_genre.get(genre).stream().collect(Collectors.summingLong(e -> e.getGross()));
            System.out.println(String.format("total gross of %s movie is %,d", genre, total_gross));
        }
    }

    public void q10() {
        Map<String, List<CSMovie>> Company = mList.stream().collect(Collectors.groupingBy(CSMovie::getCompany));
        List<Long> movies = new ArrayList<>();
        for (String company : Company.keySet()) {
            movies.add(Company.get(company).stream().count());
        }
        Map<String, Long> unorderedMap = new HashMap<>();
        int i = 0;
        for (String company : Company.keySet()) {
            unorderedMap.put(company, movies.get(i));
            i++;
        }
        Map<String, Long> orderedMap = unorderedMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Entry.comparingByValue(Long::compareTo)))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        int count = 0;
        for (Entry entry : orderedMap.entrySet()) {
            if (count == 10)
                break;
            System.out.println(entry.getKey() + " " + entry.getValue());
            count++;
        }
    }

    static void q11() {
        Function<String, Integer> numWords = entry -> {
            int count = 0;
            for (int i = 0; i < entry.length(); i++) {
                if (entry.charAt(i) == 'a') {
                    count++;
                }
            }
            return count;
        };
        List<String> data = Arrays.asList("one two three ", "four five ", "six seven eight nine ");
        Optional<String> opt = data.stream().max(Comparator.comparing(numWords));
        System.out.println(opt.get());
    }

    private String parseDouble(String str) {
        str = str.replaceAll("[.][0-9]+", "");
        return str.length() > 0 ? str : "0";
    }

    protected void movies() {
        try (Scanner input = new Scanner(Paths.get("movies.csv"))) {
            input.nextLine(); // skip header row
            while (input.hasNext()) {
                String row = input.nextLine();
                rowCount++;
                String[] tokens = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                if (tokens.length < 15) {
                    incompleteCount++;
                    System.out.println(rowCount + " " + incompleteCount + "is incompleted");
                    continue; // skip this row
                }
                String title = tokens[0];
                String rating = tokens[1];
                String genre = tokens[2];
                Integer year = Integer.parseInt(tokens[3]);
                Double score = Double.parseDouble(parseDouble(tokens[5]));
                Integer votes = (int) (Double.parseDouble(parseDouble(tokens[6])));
                String director = tokens[7];
                String star = tokens[9];
                String country = tokens[10];
                Integer budget = (int) (Double.parseDouble(parseDouble(tokens[11])));
                Long gross = (Long.parseLong(parseDouble(tokens[12])));
                String company = tokens[13];
                Integer runtime = (int) (Double.parseDouble(parseDouble(tokens[14])));
                if (!uniqueTitle.contains(title)) {
                    mList.add(new CSMovie(title, rating, genre, year, score, votes, director, star, country, budget,
                            gross, company, runtime));
                }
                uniqueTitle.add(title);
            }
            System.out.println("there are are " + incompleteCount + "rows of incomplemented data ");
            System.out.println("from " + rowCount + " row. (" + uniqueTitle.size() + ") unique title.");
            System.out.println("list size is " + mList.size());
        } catch (Exception e) {
            System.out.println("from IO error");
            e.printStackTrace();
        }
    }

}