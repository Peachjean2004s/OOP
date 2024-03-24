package LAB1OOP;

import java.util.ArrayList;

public class Lab1Driver {
    static Lab1Coder keng ;
    static Lab1Coder somsri;
    public static void main(String[] args) {
        q1();
        q2();
        q3();
    }
    static void q1(){
        Lab1Coder santa = new Lab1Coder();
        santa.setName("Santa");
        santa.setExperience(3);
        String str = String.format("%s has been working for %d years. ",santa.getName(),santa.getExperience());
        System.out.println(str);
    }
    static void q2(){
        somsri = new Lab1Coder("Somsri", 5);
        somsri.setLanguages("javascipt","dart");
        System.out.println(somsri.getLanguages());
    }
    static void q3(){
        keng = new Lab1Coder("keng",2);
        keng.setLanguages("java","solidity","c");
        Lab1Coder ber3 = new Lab1Coder("ber3");
        ber3.setLanguages("c","java","typescript");
        System.out.println(ber3);

        ArrayList<String>commonlanguages = ber3.findCommonlanguages(somsri);
        System.out.println(commonlanguages);
        commonlanguages = keng.findCommonlanguages(ber3);
        System.out.println(commonlanguages);
    }
}
