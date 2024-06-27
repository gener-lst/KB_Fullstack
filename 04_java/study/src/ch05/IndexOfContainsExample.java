package ch05;

public class IndexOfContainsExample {
    public static void main(String[] args) {
        String subject = "자바 프로그래밍";

        int location = subject.indexOf("프로그래밍");
        System.out.println(location);
        // 해당 인덱스부터 끝까지 subject에서 잘라냄
        String substring = subject.substring(location);
        System.out.println(substring);

        location = subject.indexOf("자바");
        // "자바" 라는 글자가 subject에 없으면 lcation에 -1을 반환
        if(location != 1) {
            System.out.println("자바와 관련된 책이군요.");
        } else {
            System.out.println("자바와 관련 없는 책이군요.");
        }

        boolean result = subject.contains("자바");
        // "자바"라는 글자가 포함되어 있다면
        if(result) {
            System.out.println("자바와 관련된 책이군요.");
        } else {
            System.out.println("자바와 관련 없는 책이군요.");
        }
    }
}
