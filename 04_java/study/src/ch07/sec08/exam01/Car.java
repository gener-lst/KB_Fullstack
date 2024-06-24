package ch07.sec08.exam01;

public class Car {
    public Tire tire1 = new Tire();
    public Tire tire2 = new HanKookTire();
    public Tire tire3 = new KumhoTire();

    public void run() {
        tire1.roll();
        tire2.roll();
        tire3.roll();
    }
}
