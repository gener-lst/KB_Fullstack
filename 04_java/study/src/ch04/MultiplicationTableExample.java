package ch04;

public class MultiplicationTableExample {
    public static void main(String[] args) {
        int result = 0;
        for(int i = 2; i <= 9; i++) {
            System.out.printf("*** %d단 ***\n", i);
            for(int j = 1; j <= 9; j++) {
                result = i * j;
                System.out.printf("%d x %d = %d\n", i, j, result);
            }
        }
    }
}
