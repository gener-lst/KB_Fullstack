package ch03;

public class LogicalOperatorExample {
    public static void main(String[] args) {
        int charCode = 'A';
//        int charCode1 = 'a';
//        int charCode2 = '5';

        // && : 앞과 뒤의 조건이 모두 true일 경우에만 True 반환
        if((65 <= charCode) & (charCode <= 90)) {
            System.out.println("대문자");
        }
        if((97 <= charCode) & (charCode <= 122)) {
            System.out.println("소문자");
        }
        if((48 <= charCode) & (charCode <= 57)) {
            System.out.println("0~9");
        }

        int value = 6;
//        int value1 = 7;

        if((value % 2 == 0) | (value % 3 == 0)) {
            System.out.println("2 또는 3의 배수");
        }

        boolean result = (value % 2 == 0) || (value % 3 == 0);
//      !: 결과값의 반대
        if(!result) {
            System.out.println("2 또는 3의 배수");
        }
    }
}
