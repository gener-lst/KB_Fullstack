package exercise;

public class GameObject {
    String name;
    int x;
    int y;

    public GameObject(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public void move(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    public void displayPosition() {
        System.out.printf("%", this.x, this.y);
    }
}
