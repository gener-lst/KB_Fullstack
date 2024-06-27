package ch04;

public class EquationSolution {
    public static void main(String[] args) {
        for(int x = 1; x < 11; x++) {
            for(int y = 1; y < 11; y++) {
                if((x * 4 + y * 5) == 60) {
                    System.out.println("해(x: " + x + ", y: " + y + ")");
                }
            }
        }
    }
}
