package ch08.sec10;

public class Bus implements Vehicle {
    @Override
    public void run() {
        System.out.println("qh");
    }

    public void checkFare() {
        System.out.println("dd");
    }
}
