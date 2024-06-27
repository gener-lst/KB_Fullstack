package exercise;

public class Player extends GameObject {
    int health;

    public Player(String name, int x, int y, int health) {
        super(name, x, y);
        this.health = health;
    }

    public int attack() {
        System.out.println("Hero attacks with full power!");
        return 15;
    }

    public void displayStatus() {
        System.out.printf("Hero has %d health remaining", health);
    }
}
