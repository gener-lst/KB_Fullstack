package ch06.q5;

public class Car {
    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;

    Car(String model) {

    }

    Car(String model, String color) {

    }

    Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
