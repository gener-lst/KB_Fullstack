package exercise;

public class Game {
    public static void main(String[] args) {
        Player player = new Player("Hero", 0, 0, 100);
        Enemy enemy = new Enemy("Goblin", 10, 10, 15);
        Item potion = new Item("Health Potion", 5, 5, "Healing");
    }
}
