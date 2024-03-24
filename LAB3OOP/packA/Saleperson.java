package LAB3OOP.packA;

public class Saleperson extends EmpTmp {
    private int target ;

    public Saleperson(String name, int experience, int salary, int target) {
        super(name, experience, salary);
        this.target = target;
    }
    public Saleperson(String name , int exp){
        super(name);
        super.setExperience(exp);
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public void setSalary(int increseAmount){
       salary += increseAmount;
    }
    public void setSalary() {
        salary *= 1.1 ;
    }
    public  String makeQuotation(){
        return "Dear value customer, " + (int)(Math.random()*1000)+ " is my best offer";
    }
    public String toString(){
        return "Salesperson [target = " + target + " " + super.toString() + " ]";
        
    }
    
    
    

   
    
}
