package LAB9OOP;

public class Employee
{
    String id;
    String name;
    int salary;

    public Employee(String n) 
    { 
        name = n; 
        int sal = 0; 
        for (int j = 0; j < name.length(); j++)  
            sal += name.charAt(j); 
        salary = sal; 
        int memAddress = System.identityHashCode(this); 
        id = Integer.toHexString(memAddress); 
      } 
       
    @Override 
    public String toString() 
    { 
        return id + " [" + name + "(" + salary + ")]"; 
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }
    
}