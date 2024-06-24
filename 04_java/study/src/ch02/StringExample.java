package ch02;

public class StringExample {
    public static void main(String[] args) {
        String name = "홍길동";
        String job = "프로그래머";
        System.out.println(name);
        System.out.println(job);

        String str = "나는 \"자바\"를 배웁니다";
        System.out.println(str);

        // 위에서 정의한 str 변수를 변경해줌
        // \t 탭 하나 추가
        str = "번호\t이름\t직업";
        System.out.println(str);

        // \n 줄바꿈

    }
}
