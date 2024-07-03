package ch16.sec4;

public class Person {
    public void action(Calculable calculable) {
//        calc 함수는 매개변수가 2개고 return 값이 double인 함수 - 예측 가능
        double result = calculable.calc(10, 4);
        System.out.println("결과: " +result);
    }
}
