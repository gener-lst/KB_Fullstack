package ch03;

public class Trapezoid {
    public static void main(String[] args) {
        double upperBase = 5;
        double lowerBase = 10;
        double height = 7;
        double area = (upperBase + lowerBase) / 2 * height;

        System.out.println("사다리꼴의 넓이: " + area  + "cm^2");
    }
}
