package exercise;

public class OutOfMenuException extends Throwable{
    String message = "메뉴 범위 내에서 입력하세요.";

    @Override
    public String getMessage() {
        return message;
    }
}
