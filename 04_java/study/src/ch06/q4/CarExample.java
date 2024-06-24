package ch06.q4;

public class CarExample {
    public static void main(String[] args) {
        Car car1 = new Car("자가용", "빨강");
        Car car2 = new Car("택시", "검정", 200);



        System.out.printf("car1.company: %s", car1.company);

        System.out.printf("car1.company: %s", car1.company);
        System.out.printf("car1.model: %s", car1.model);

        System.out.printf("car1.company: %s", car1.company);
        System.out.printf("car1.model: %s", car1.model);
        System.out.printf("car1.color: %s", car1.color);

        System.out.printf("car2.company: %s", car2.company);
        System.out.printf("car2.model: %s", car2.model);
        System.out.printf("car2.color: %s", car2.color);
        System.out.printf("car2.maxSpeed: %s", 200);
    }
}
