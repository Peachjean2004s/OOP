package LAB1OOP;

import java.util.ArrayList;

public class Lab1Coder {
    private String name;
    int experience;
    ArrayList<String> languages = new ArrayList<>();

    Lab1Coder() {

    }

    Lab1Coder(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    Lab1Coder(String name) {
        this.name = name;
        experience = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(String... lang) {
        for (String i : lang) {
            languages.add(i);
        }
    }

    public String toString() {
        if (languages.isEmpty()) {
            return "null";
        } else {
            return name + "(" + experience + ") knows " + String.join(" ", languages);
        }

    }

    ArrayList<String> findCommonlanguages(Lab1Coder other) {
        ArrayList<String> check = new ArrayList<>();
        if(other != null)
        {
            for (String i : languages) {
                if (other.languages.contains(i)) {
                    check.add(i);
                }
            }
        }
        if(check.size() == 0 ){
            check.add("none");
        }
        return check;
    }

}
