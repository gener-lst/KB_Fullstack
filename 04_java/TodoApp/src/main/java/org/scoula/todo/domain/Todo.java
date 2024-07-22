package org.scoula.todo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Todo implements Cloneable { // 복제(clone)을 허용하는 인터페이스
    private static int gid = 1; // Todo id 발급을 위한 스태틱 변수

    private int id;
    private String title;
    private String description;
    private boolean done;
    private Date date;

    @Builder
    public Todo(String title, String description, boolean done, Date date) {
        this(gid++, title, description, done, new Date());
    }

    @Override
    public Object clone() {
        try {
            return super.clone(); // 얇은 복사
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getRegDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }
}
