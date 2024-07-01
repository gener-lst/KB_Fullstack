package exercise;

import ch04.SwitchCharExample;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    static Scanner scanner = new Scanner(System.in);
    int x = 0;
    int y = 0;

    public static void main(String[] args) {
        Player player = new Player("Hero", 0, 0, 100);
        Enemy enemy = new Enemy("Goblin", 10, 10, 15);
        Item potion = new Item("Health Potion", 5, 5, "Healing");

        int choice = 0;

        while(true) {
            System.out.println("1. 이동 | 2. 공격 | 3. 아이템 사용");
            try {
                choice = scanner.nextInt();
                if(choice > 3) {
                    throw new OutOfMenuException();
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
            }
            catch (OutOfMenuException e) {
                e.getMessage();
            }
            switch (choice) {
                case 1:
//                    getCoordinate(player);
                case 2:

            }
        }
    }

    public static void movingAction(Player player) {
        int x = scanner.nextInt();
        scanner.nextLine();
        int y = scanner.nextInt();
        scanner.nextLine();
        player.move(x, y);
    }

    public static void attackingAction() {

    }
}
