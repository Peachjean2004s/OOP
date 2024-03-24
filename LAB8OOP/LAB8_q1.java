package LAB8OOP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class LAB8_q1 {

    public static void main(String[] args) {
        q1_halfEachNumber();
        q2_forEachSingerName();
        q3_lambda_comparator();
        q4_method_reference_comparator();

    }

    static List<Singer> singerList;
    static {
        singerList = new ArrayList<>();
        singerList.add(new Singer("aba", Style.POP));
        singerList.add(new Singer("abi", Style.ROCK));
        singerList.add(new Singer("abo", Style.ROCK));
        singerList.add(new Singer("abe", Style.POP));
    }

    public static void q1_halfEachNumber() {
        List<Integer> nums = Arrays.asList(100, 105);
        HalfValueInterface q0 = new HalfValueInterface() {
            public void printHalf(int n) {
                System.out.println(n / 2);
            }
        };
        for (int n : nums) {
            q0.printHalf(n);
        }
        System.out.println("---q1.1---");
        HalfValueInterface halfVal = n -> System.out.println(n / 2);
        for (int n : nums) {
            halfVal.printHalf(n);
        }
        System.out.println("---q1.2---");
        Consumer<Integer> consumer = n -> System.out.println(n / 2);
        for (int n : nums) {
            consumer.accept(n);
        }
        System.out.println("---q1.3---");
        Consumer<Integer> halfMe = n -> System.out.println(n / 2);
        nums.forEach(halfMe);

        System.out.println("---q1.4---");
        nums.forEach(n -> System.out.println(n / 2));

        System.out.println("---q1.5---");
        NumberProcessor np = new NumberProcessor();
        nums.forEach(np::printHalf);
    }

    public static void q2_forEachSingerName() {
        System.out.println("---q2.1---");
        singerList.stream().map(singer -> singer.getName()).forEach(System.out::println);
        System.out.println("---q2.2---");
        singerList.stream().map(Singer::getName).forEach(System.out::println);
    }

    public static void q3_lambda_comparator() {
        Comparator<Singer> byStyle1 = new Comparator<>() {
            @Override
            public int compare(Singer o1, Singer o2) {
                return o1.getStyleString().compareTo(o2.getStyleString());

            } // by Enum .ordinal() 
        };
        Collections.sort(singerList, byStyle1);
        singerList.forEach(System.out::println);
        System.out.println("---q3.1---");
        Comparator<Singer> byStyle2 = Comparator.comparing(singer -> singer.getStyleString());
        Collections.sort(singerList, byStyle2);
        singerList.forEach(System.out::println);

    }

    public static void q4_method_reference_comparator() {
        System.out.println("q4.1--------");
        Comparator<Singer> byName = Comparator.comparing(Singer::getStyleString);
        Collections.sort(singerList, byName);
        singerList.forEach(System.out::println);
        System.out.println("q4.2--------");
        singerList.sort((p, q) -> p.getStyleString().compareTo(q.getStyleString()));
        singerList.forEach(System.out::println);
        System.out.println("q4.3--------");
        Collections.sort(singerList,Singer::compareByName);
        singerList.forEach(System.out::println);
        System.out.println("q4.4--------");
        singerList.sort(Singer::compareByName); 
        singerList.forEach(System.out::println);
    }
}