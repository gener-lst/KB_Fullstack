package ch18.sec03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {
    public static void main(String[] args) {
        String originalFileName = "C:/Temp/test.jpg";
        String targetFileName = "C:/Temp/test2.jpg";

        try (
            InputStream in = new FileInputStream(originalFileName);
            OutputStream out = new FileOutputStream(targetFileName)
        ) {
            byte[] data = new byte[1024];
            while (true) {
                int num = in.read(data);
                if (num == -1) break;
                out.write(data, 0, num);
            }

            out.flush();
            System.out.println("복사가 잘 되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
