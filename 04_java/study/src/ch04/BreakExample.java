package ch04;

public class BreakExample {
    public static void main(String[] args) throws Exception {
        int random = 0;
        while(true) {
            random = (int)(Math.random() * 6) + 1;
            System.out.println(random);
            if(random == 6) {
                System.out.println("프로그램 종료");
                break;
            }
        }
    }
}
