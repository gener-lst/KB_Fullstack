package ch12.sec12;

import ch12.sec03.exam4.Member;
import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Method;

public class PrintAnnotationExample {
    public static void main(String[] args) throws Exception {
        Method[] declareMethods = Service.class.getDeclaredMethods();
        for(Method method : declareMethods) {
            PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);

            printLine(printAnnotation);
            method.invoke(new Service());

            printLine(printAnnotation);
        }
    }

    private static void printLine(PrintAnnotation printAnnotation) {
    int number = printAnnotation.number();
    for(int i=0; i<number; i++) {
        String value = printAnnotation.value();
            System.out.print(value);
        }
        System.out.println();
    }

}
