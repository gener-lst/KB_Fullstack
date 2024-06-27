package ch05;

public class AdvancedForExample {
    public static void main(String[] args) {
        int[] scores = {95, 71, 84, 93, 87};
        int sum = 0;
        double avg = 0;

        for (int score : scores) {
            sum += score;
        }
        avg = (double) sum / scores.length;

        System.out.printf("Score의 총점은 %d점, 평균은 %f점입니다.", sum, avg);
    }
}
