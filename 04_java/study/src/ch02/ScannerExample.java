package ch02;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        // Scanner 클래스를 이용해서 새로운 스캐너 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 다음 칸에 입력받기 위해 print로 입력문 출력
        System.out.print("x 값 입력: ");
        // 스캐너로 한줄을 입력받아서 저장
        String temp = scanner.nextLine();
        // temp를 int로 형변환
        int x = Integer.parseInt(temp);

        System.out.print("y 값 입력: ");
        int y = scanner.nextInt();
        // nextInt를 통해 한 번에 int로 받아올 수 있다.
        scanner.nextLine();
//        nextInt에서 엔터값은 안 가져가고 남기기 때문에
        System.out.printf("x + y: %d\n", x + y);

        // 무한 루프
        while(true) {
            System.out.print("입력 문자열 : ");
            String data = scanner.nextLine();
            // 문자열의 값을 비교할 때 equals 사용
            if(data.equals("q")){
                // 무한 루프문은 보통 break와 함께 사용
                break;
            }
            System.out.println("출력 문자열 : " + data);
            System.out.println();
        }

        System.out.println("종료");
    }
}
