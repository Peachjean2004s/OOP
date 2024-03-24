package LAB8OOP;

public class Singer {
    String name;
    Style style;

    public Singer(String n, Style s) {
        name = n;
        style = s;
    }

    public String getName() {
        return name;
    }

    public String getStyleString() {
        return style.toString();
    }

    @Override
    public String toString() {
        return "Singer ("+name+ "-SingStyle." +style + ")";
    }
    
    public int compareByName(Singer s) {
        return name.compareTo(s.getName());
    }
}

enum Style {
    POP, ROCK;

}

