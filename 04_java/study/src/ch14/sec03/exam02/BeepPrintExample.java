package ch14.sec03.exam02;

import java.awt.*;

public class BeepPrintExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() { // 작업 스레드 생성
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for(int i = 0; i<5 ; i++) {
                    toolkit.beep(); // 비프음 발생
                    // 0.5초간 일시 정지
                    try {Thread.sleep(500); } catch (Exception e) {

                    }
                }
            }
        });
        thread.start(); // 작업 스레드 실행
    }
}
