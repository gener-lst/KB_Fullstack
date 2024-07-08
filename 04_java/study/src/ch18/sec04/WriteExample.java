package ch18.sec04;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteExample {
    public static void main(String[] args) {
        try(Writer writer = new FileWriter("C:/Temp/test.txt")) {

            char a = 'A';
            writer.write(a);
            char b = 'B';
            writer.write(b);

            char[] arr = {'C', 'D', 'E', 'F'};
            writer.write(arr);

            writer.write("FGH");

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
