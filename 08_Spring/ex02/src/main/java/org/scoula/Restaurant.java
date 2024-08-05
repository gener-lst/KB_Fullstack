package org.scoula;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data // 기본 생성자, getter/setter, equals(), hashCode(), toString()
@RequiredArgsConstructor // final이 붙은 필드를 무조건 생성자에 넣겠다.
public class Restaurant {
//    @Autowired // 외부에서 의존성 주입해서 자동 연결하겠다.
    final private Chef chef;

//    Restaurant(Chef chef);
//    requireArgsConstructor를 통해 autowired 없이도 연결 및 주입 가능 -> autowired보다 해당 annotation과 final 변수 추천
}