package packA;

import java.util.ArrayList;

public class Programmer extends Employee {
    ArrayList<String> skills = new ArrayList<>();

    public Programmer(String n, int exp, int sal) {
        this.name = n;
        this.experience = exp;
        this.salary = sal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setSalary(int newSalary) {
        this.salary = newSalary;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setExperience(int exp) {
        this.experience = exp;
    }

    public int getExperience() {
        return this.experience;
    }

    public String toString() {
        return String.format("Programmer [name = %s, salary = %d, experience = %d]", this.name, this.salary,
                this.experience);
    }

    public void sayHi() {
        System.out.println("hi from " + this.name);
    }

    public String coding() {
        return "Coding from programmer";
    }
}