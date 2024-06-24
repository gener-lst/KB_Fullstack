package ch04;

public class SumFrom1To100Example {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum +=  i;
        }
        System.out.println("1~100 합: " + sum);

        int sum2 = 0;
        int j = 1;
        while(j <= 100) {
            sum2 += j;
        }
        System.out.println("1~100 합: " + sum2);
    }
}
