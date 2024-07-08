package ch18.sec03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {
    public static void main(String[] args) {
        try (InputStream isr = new FileInputStream("C:/Temp/test1.db")) {
            while(true) {
                int data = isr.read();
                if (data == -1) break;
                System.out.println(data);
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
