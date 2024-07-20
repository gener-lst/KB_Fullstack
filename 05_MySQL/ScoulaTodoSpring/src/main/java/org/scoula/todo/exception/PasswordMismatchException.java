package org.scoula.todo.exception;

public class PasswordMismatchException extends Exception{
    public PasswordMismatchException() {
        super("비밀번호가 맞지 않습니다.");
    }
}
