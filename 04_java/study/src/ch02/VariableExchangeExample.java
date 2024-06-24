package ch02;

public class VariableExchangeExample {
    public static void main(String[] args) {
        int x = 3;
        int y = 5;
        System.out.printf("x:%d, y:%d\n", x, y );

        int temp = x;
        x = y;
        y = temp;
        System.out.printf("x:%d, y:%d", x, y );
    }
}
