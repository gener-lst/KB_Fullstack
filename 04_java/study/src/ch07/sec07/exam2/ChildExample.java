package ch07.sec07.exam2;

public class ChildExample {
    public static void main(String[] args) {
        Child child = new Child();
        Parent parent = child;

        parent.method1();
        parent.method2();
//        parent.method3();
//        child에 Parent로 타입 캐스팅을 해버려서 method3는 사용 불가
    }
}
