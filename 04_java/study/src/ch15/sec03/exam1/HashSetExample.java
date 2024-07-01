package ch15.sec03.exam1;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        set.add("A");
        set.add("B");
        set.add("C");
        set.add("A");
        set.add("E");

        int size = set.size();
        System.out.println("총 객체 수: " + size);
    }
}
