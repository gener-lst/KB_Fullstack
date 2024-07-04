package ch17.sec04.exam2;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class q1 {
    public static void main(String[] args) {
        String[] strArray = {"홍길동", "신용권", "김미나"};

        int[] intArray = {1, 2, 3, 4, 5};

        Stream<String> s1 = Arrays.stream(strArray);
        IntStream i1 = Arrays.stream(intArray);

        s1.forEach(name -> System.out.print(name + ", "));
        System.out.println();
        i1.forEach(num -> System.out.print(num + ", "));
    }
}
