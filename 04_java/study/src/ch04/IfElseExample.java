package ch04;

public class IfElseExample {
    public static void main(String[] args) {
        int score = 93;

        if(score >= 90) {
            System.out.println("점수가 90보다 큽니다.");
            System.out.println("등급은 A입니다.");
        } else {
            // 위의 if 문이 true일 경우 아래 조건은 체크하지 않는다.
            System.out.println("점수가 90보다 작습니다.");
            System.out.println("등급은 B입니다.");
        }
    }
}
