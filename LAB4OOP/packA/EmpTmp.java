package packA;

public class EmpTmp {
    protected String name ;
    protected int salary ;
    protected int experience ;

    public EmpTmp(String name, int salary, int experience) {
        this.name = name;
        this.salary = salary;
        this.experience = experience;
    }
    public EmpTmp(String name) {
        this.name = name;
       
    }
    public EmpTmp(){

    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    @Override
    public String toString() {
        return "EmpTmp [name=" + name + ", salary=" + salary + ", experience=" + experience + "]";
    }
    public void sayHi(){
        System.out.println("HI, i am EMPTMP");
    }

    
}
