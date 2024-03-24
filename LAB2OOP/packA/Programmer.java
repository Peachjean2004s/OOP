package LAB2OOP.packA;

public class Programmer {
    private String name ;
    int experience ;
    protected int salary ;

    public Programmer(String name, int experience, int salary) {
        this.name = name;
        this.experience = experience;
        this.salary = salary;
    }
    public Programmer(String name) {
        this.name = name;
      
    }
    public Programmer(){

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
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String toString(){
        return "Programmer [name="+name+ ",experience=" + experience + ",salary="+ salary +"]";
    }
    public void sayHi(){
        System.out.println("HI FROM " + name);
    }
    
    
}
