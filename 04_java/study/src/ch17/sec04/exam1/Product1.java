package ch17.sec04.exam1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
// @Data 하나만 정의하면 됨
public class Product1 {
    private int pno;
    private String name;
    private String company;
    private int price;
}
