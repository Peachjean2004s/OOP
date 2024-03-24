package LAB2OOP.packA;

public class Accountant extends Programmer{
    private static String companyName = "berk barn jamkad" ;
    private int experience ;
    private String specailty;

    public Accountant(String Name,int superEXP, int exp,int sal ,String talent) {
        super(Name,superEXP,sal);
        experience = exp;
        specailty = talent;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getSpecailty() {
        return specailty;
    }

    public void setSpecailty(String specailty) {
        this.specailty = specailty;
    }
    public String tellProfit(){
        return String.format("berk barn jamkad's Profit is %d . My salary is %d",(int)(Math.random()*1000),salary);
    }
    public String toString(){
        return  String.format("Accountant [experience=%d , specialty=%s]",experience,specailty);
    }
    public void sayHi(){
        System.out.println(getName() +" says hello ");
    }
    public static String tellmyRole(){
        return "I am accountant at "+companyName ;

    }

    
}
