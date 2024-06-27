package v1;

import java.util.Scanner;

public class App {
    //여러 메소드에서 사용할 변수는 위로 정렬
    boolean run = true;
    int studentNum = 0;
    int[] scores = null;

    Scanner scanner = new Scanner(System.in);

    // 메뉴 출력하는 메소드
    public void printMenu() {
        System.out.println("------------------------------------------------");
        System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
        System.out.println("------------------------------------------------");
    }

    // 사용자가 입력한 메뉴번호 리턴
    public int getSelect() {
        System.out.println("선택>");
        return Integer.parseInt(scanner.nextLine());
    }

//    4. 저장된 데이터 분석 기능
    private void analyze() {
        int max = 0;
        int sum = 0;
        double avg = 0;
        for(int i = 0; i<scores.length; i++) {
            max = (max<scores[i]) ? scores[i] : max;
            sum += scores[i];
        }
        avg = (double) sum / studentNum;
        System.out.println("최고 점수: " + max);
        System.out.println("평균 점수: " + avg);
    }

    // 1. 학생 수 입력
    public void getStudentNum() {
        System.out.println("학생수> ");
        studentNum = Integer.parseInt(scanner.nextLine());
        scores = new int[studentNum];
    }

    // 2. 점수 입력 기능을 처리하는 메소드
    public void getScores() {
        for (int i = 0; i < scores.length; i++) {
            System.out.println("scores[" + i +"]> ");
            scores[i] = Integer.parseInt(scanner.nextLine());
        }
    }

    // 3. 점수 출력 기능을 처리하는 메소드
    public void printScore() {
        for(int i = 0; i < scores.length; i++) {
            System.out.println("scores[" + i +"]: " + scores[i]);
        }
    }

    // 5. 종료
    public void exit() {
        run = false;
    }

    // 만들어준 메소드들을 사용자의 입력값에 따라 호출
    public void executeCommand(int selectNo) {
        if(selectNo == 1) {
            getStudentNum();
        } else if (selectNo == 2) {
            getScores();
        } else if (selectNo == 3) {
            printScore();
        } else if (selectNo == 4) {
            analyze();
        }else if (selectNo == 5) {
            exit();
        }
    }

    public void run() {
        while(run) {
            printMenu();
//            getSelect는 int를 반환하는 메소드기 때문에 바로 받아와서 처리
            int selectNo = getSelect();
            executeCommand(selectNo);
        }
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
