import packA.CanswimIntf;

public class Lec4Duck implements CanswimIntf{

    @Override
    public void swim() {
        // TODO Auto-generated method stub
        System.out.println("waddling");
    }

    protected void duckMethod(){
        System.out.println("quack");
    }
    
}
