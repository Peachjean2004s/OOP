package packA;

public class Saleperson extends Employee implements SalesRoles {
    private int target ;
    private double salary;

    public Saleperson(String name, int experience, int salary, int target) {
        this.name = name ;
        this.experience = experience ;
        this.target = target;
        this.salary = salary;

    }
    public Saleperson(String name , int exp){
        this.name = name ;
        this.experience = exp;

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
  
    public String toString(){
        return "Salesperson [target = " + target + " " + super.toString() + " ]";
        
    }
    public void sayHi(){
        System.out.println("sayHi Saleperson");
    }
    @Override
    public String makeQuotation() {
        // TODO Auto-generated method stub
        return "Dear value customer, " + (int)(Math.random()*1000)+ " is my best offer";
    }
    
    
    

   
    
}
