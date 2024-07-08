package ch18.sec01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
    public static void main(String[] args) {
//        try(OutputStream os = new FileOutputStream("C:\\temp\\test1.db"))
//        대체 가능
        try {
            OutputStream os = new FileOutputStream("C:/temp/test1.db");

            byte a = 10;
            byte b = 20;
            byte c = 30;

            os.write(a);
            os.write(b);
            os.write(c);

            os.flush();
            os.close();
//        OutputStream 객체를 인자로 받을 경우엔 flush와 close가 필요 없게 됨
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
