package ch04;

import java.util.Scanner;

public class AccountSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menu;
        int balance = 0;
        int deposit;
        int expense;
        boolean loop = true;

        while(loop) {
            System.out.println("------------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("------------------------------");
            System.out.print("선택>");

            menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    System.out.print("예금액>");
                    deposit = scanner.nextInt();
                    balance += deposit;
                    break;
                case 2:
                    System.out.print("출금액>");
                    expense = scanner.nextInt();
                    if (expense <= balance ) {
                        balance -= expense;
                        break;
                    } else {
                        System.out.println("출금액이 잔고보다 많습니다!!!");
                    }
                case 3:
                    System.out.println("잔고>" + balance);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
