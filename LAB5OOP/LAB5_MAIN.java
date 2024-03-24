package LAB5OOP;

import java.util.Arrays;

public class LAB5_MAIN {
    static int[] data = { 28, 58, 8, 77, 48, 39 };
    static ArrayProcessor q1NumberOfEvenElement; // 4
    static ArrayProcessor q2IndexOfLargestEvenValue; // 1
    static ArrayProcessor myMedian; // n/2th element of sorted = 48

    public static void main(String[] args) {
        q1(); // 4
        q2(); // 1
        oneline(); // 48
    }
    static void q1(){
        q1NumberOfEvenElement =(x) -> {
            int result = 0 ;
            for(int i : x){
                if(i % 2 == 0){
                    result++;
                }
            }
            return result ;

        } ;
        System.out.println(q1NumberOfEvenElement.calculate(data));
    }
    static void q2(){
        q2IndexOfLargestEvenValue =(x) -> {
            int index = 0 ;
            int min = Integer.MIN_VALUE;
            for(int i = 0 ; i < x.length ; i++){
                if(x[i] %2 == 0 && x[i] > min ){
                    index = i;
                    min = x[i];
                }
            }
            return index ;
        };
        System.out.println(q2IndexOfLargestEvenValue.calculate(data));
    }
    static void oneline() {
        int[] tmp = Arrays.copyOf(data, data.length);
        Arrays.sort(tmp);
        myMedian =(x) -> x[data.length/2] ;
        /* q3 */ // one statement
        System.out.println(myMedian.calculate(tmp)); // 48
    }
}
