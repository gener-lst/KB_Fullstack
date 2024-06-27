package ch14.sec03.exam01;

import java.awt.*;

public class BeepPrintExample {
    public static void main(String[] args) {
        // 하나의 메인 스레드에서 작동하므로 비프음 5번 발생 후 "띵" 5번 출력
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
    
        }
        
        for(int i=0; i<5; i++) {
            System.out.println("띵");
            try{
                System.out.println("띵");
            } catch (Exception e) {
                
            }
        }
    }
            
    
}
