package ch04;

public class Tree2 {
    public static void main(String[] args) {
        for(int i = 5; i > 0; i--) {
            System.out.println();
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }
        }
    }
}
