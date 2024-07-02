package ch15.sec04.exam1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.*;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap();

        map.put("A", 85);
        map.put("B", 90);
        map.put("C", 80);
        map.put("A", 95);
        System.out.println("총 Entry 수: " + map.size());
        System.out.println();

        String key = "A";
        int value = map.get(key);
        System.out.println(key + " : " + value);
        System.out.println();

        Set<String> keySet = map.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        while (keyIterator.hasNext()) {
            String k = keyIterator.next();
            Integer v = map.get(k);
            System.out.println(k + " : " + v);
        }
        System.out.println();

        Set<Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            Entry<String, Integer> entry = entryIterator.next();
            String k = entry.getKey();
            Integer v = entry.getValue();
            System.out.println(k + " : " + v);
        }
        System.out.println();

        map.remove("A");

        System.out.println("총 Entry 수: " + map.size());
        System.out.println();
    }
}
