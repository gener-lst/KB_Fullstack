package ch15.sec03.exam3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
//        HashSet 컬렉션 생성
        Set<String> set = new HashSet<String>();

//        객체 추가
        set.add("Java");
        set.add("JDBC");
        set.add("JSP");
        set.add("Spring");
        
//        객체를 하나씩 가져와서 처리
//        set 내에서 반복 기능을 사용하기 위해 iterator를 가져옴
        Iterator<String> iterator = set.iterator();
//        hasNext : 다음으로 가져올 요소가 있으면 true, 아니면 false 반환
        while (iterator.hasNext()) {
//            요소들를 돌면서 객체를 하나씩 가져오기 
            String element = iterator.next();
            System.out.println(element);
//            요소들을 돌면서 JSP 인지 체크
            if(element.equals("JSP")) {
//                가져온 객체를 컬렉션에서 제거
                iterator.remove();
            }
        }
        System.out.println();
//        객체 제거
        set.remove("JDBC");
//        객체를 하나씩 가져와서 처리
        for (String element : set) {
            System.out.println(element);
        }
    }
}
