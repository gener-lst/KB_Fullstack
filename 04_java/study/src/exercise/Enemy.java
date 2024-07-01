package exercise;

public class Enemy extends GameObject {
    int damage;

    public Enemy(String name, int x, int y, int damage) {
        super(name, x, y);
        this.damage = damage;
    }

    public void attack() {
        System.out.println();
    }
}
