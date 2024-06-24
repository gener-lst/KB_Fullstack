package ch04;

public class ThreeSolution {
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1; i <= 100; i++) {
            if((i % 3) == 0) {
                sum += i;
            }
        }
        System.out.printf("3의 배수의 총합: %d", sum);
    }
}
