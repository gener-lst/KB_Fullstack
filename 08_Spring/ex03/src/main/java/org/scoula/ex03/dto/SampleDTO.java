package org.scoula.ex03.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor // 기본 생성자가 없어짐
// getter/setter 생성
public class SampleDTO {
    private String name;
    private int age;
}
