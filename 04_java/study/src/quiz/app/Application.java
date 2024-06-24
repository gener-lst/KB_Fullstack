package quiz.app;

import static quiz.Input.scanner;

public abstract class Application {
    Input input = new Input();

    public abstract void createMenu();

    public void init() {
        System.out.println("어플리케이션을 초기화합니다.");
        createMenu();
    }

    public void cleanup() {
        System.out.println("어플리케이션을 정리합니다.");
    }

    public void run() {
        int answer = 0;
        init();
        while(true) {
            System.out.print("선택> ");
            answer = input.readInt();
            if(answer == 0) {
                cleanup();
                break;
            } else {
                System.out.println(answer + "룰 입력했습니다.");
            }
        }
    }
}
