package ch15.sec02.exam01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
// 필드 전부를 가지고 있는 생성자를 만듦
// @NoArgsConstructor -> 기본 생성자
@Getter
@Setter
// @Data -> getter/setter/ToString/EqualsAndHashCode/RequiredArgsConstructor를 포함
public class Board {
    private String subject;
    private String content;
    private String writer;
}
