package ch12.sec03.exam5;

import lombok.Data;
import lombok.NonNull;
// ctrl + alt + o : 안쓰는 import 제거

@Data
public class Member2 {
    private String id;
    @NonNull // null이면 안 되는 필수 항목
             // -> @RequireArgsConstructor에 의해 해당 필드를 포함하는 생성자가 만들어짐
    private String name;
    private int age;
}
