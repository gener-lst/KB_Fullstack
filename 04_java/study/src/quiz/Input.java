package quiz;

import java.util.Scanner;

public class Input {
    public static Scanner scanner = new Scanner(System.in);
    public static String input = null;
    public static int value = 0;
    
    public static String read(String title) {
        return read(title, "기본값");
    }

    public static String read(String title, String defaultValue) {
        System.out.printf("입력값: %s", title, defaultValue);
        if(input != "") {
            return input;
        } else {
            input = defaultValue;
            return input;
        }
    }

    public static int readInt(String title) {
        System.out.printf("입력값: %s", title);
        input = scanner.nextLine();
        value = Integer.parseInt(input);
        return value;
    }

    public static boolean confirm(String title, boolean defaultValue) {
        System.out.printf("%s (Y/N)", title);
        input = scanner.nextLine();
        if(defaultValue == true) {
            System.out.println("Y/n");
            return true;
        } else {
            System.out.println("y/N");
            return false;
        }
    }

    public static boolean confirm(String title) {
        return confirm(title, false);
    }

    public static void input() {
        System.out.println("Input 프로그램 시작합니다!");
        System.out.println("----------------------");
        System.out.println("1.문자열 2.정수 3.yes/no");
        value = scanner.nextInt();
        scanner.nextLine();
        System.out.println("값을 입력하세요");
        input = scanner.nextLine();
        switch (value) {
            case 1:
                read(input);
                break;
            case 2:
                readInt(input);
                break;
            case 3:
                confirm(input);
        }
    }
}
