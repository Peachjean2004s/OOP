package packA;

public class ProgrammerManager extends Programmer implements ManagerRoles {

    public ProgrammerManager(String n, int exp, int sal) {
        super(n, exp, sal);
    }

    public void sayHi() {
        System.out.println("Coding in [solidity, typescript]");
    }

    public int evaluate(Programmer p) {
        int new_salary ;
        new_salary = p.getSalary() + (int)(p.getSalary() * 0.15);
        return new_salary;
    }

    @Override
    public String toString() {
        return String.format("ManagerProgrammer [name = %s, experience = %d, salary = %d]", name, experience, salary);
    }
}