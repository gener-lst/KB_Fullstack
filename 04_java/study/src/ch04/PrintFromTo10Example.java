package ch04;

public class PrintFromTo10Example {
    public static void main(String[] args) {
        for(int i = 1; i < 11; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        int j = 1;
        while(j <= 10) {
            System.out.print(j + " ");
            j++;
        }
    }
}
