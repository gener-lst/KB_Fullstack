package ch05;

public class ArrayLengthExample {
    public static void main(String[] args) {
        int[] scores = {84, 90, 96};
        int sum = 0;


        for (int score : scores) {
            sum += score;
        }
        Double avg = (double)sum / scores.length;

        System.out.printf("Score의 총점은 %d점, 평균은 %d점입니다.", sum, avg);
    }
}
