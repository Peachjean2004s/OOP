package LAB3OOP;

import java.util.ArrayList;
import LAB3OOP.packA.*;

public class main {
    public static void main(String[] args) {
        q1();
    }
    static void q1()
    {
        ArrayList<EmpTmp> aList = new ArrayList<>();
        aList.add(new Accountant("goodAtmyJob", 7, 6, 390, "sing"));
        aList.add(new Accountant("canRap", 4, 9, 480, "rap"));
        aList.add(new Saleperson("mr.salesperson", 5, 150, 5000));
        aList.add(new Saleperson("mr.kayan", 3, 260, 9000));
        aList.add(new Programmer("Keng", 2, 300));
        aList.add(new EmpTmp("invisible", 9, 120));

        System.out.println("--------------------Upcasting---------------------");
        for (EmpTmp e : aList)
            e.sayHi();

        System.out.println("--------------------Downcasting--------------------");

        for (EmpTmp e : aList)
        {
            String str;
            //---------------------------- start of Q1 ----------------------------------//
            if (e instanceof Accountant)
                str = ((Accountant)e).tellProfit();
            else if (e instanceof Programmer)
                str = ((Programmer)e).coding();
            else if (e instanceof Saleperson)
                str = ((Saleperson)e).makeQuotation();
            else
                continue;
            //---------------------------- end of Q1 ----------------------------------//
            System.out.println(str);
        }
    }
} 