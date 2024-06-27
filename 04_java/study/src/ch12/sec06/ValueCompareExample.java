package ch12.sec06;

public class ValueCompareExample {
    public static void main(String[] args) {
        // -128~127 초과값일 경우
        Integer obj1 = 300;
        Integer obj2 = 300;
        System.out.println("==: " + (obj1 == obj2));
        System.out.println("equals(): "+ obj1.equals(obj2));
    }
}
