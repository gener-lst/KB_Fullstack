package ch04;

public class IfExample {
    public static void main(String[] args) {
        int score = 93;

        if(score >= 90) {
            System.out.println("점수가 90보다 큽니다.");
            System.out.println("등급은 A입니다.");
        }

        // if문에 대한 스코프를 처리하지 않을 경우, 바로 아래 문장만 조건식 적용
        if(score < 90)
            System.out.println("점수가 90보다 작습니다.");
            System.out.println("등급은 B입니다.");
    }
}
