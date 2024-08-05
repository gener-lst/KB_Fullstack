package org.scoula;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
// static 메서드를 바로 사용가능

@ExtendWith(SpringExtension.class) // Spring test임
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
class RestaurantTest {
    @Autowired
    private Restaurant restaurant;

    @Test
    void getChef() {
//      assertNotNull: restaurant 객체가 null이 아님을 확인하는 메소드
        assertNotNull(restaurant);
        log.info(restaurant);
        log.info("-----------------------------------");
        log.info(restaurant.getChef());
    }
}