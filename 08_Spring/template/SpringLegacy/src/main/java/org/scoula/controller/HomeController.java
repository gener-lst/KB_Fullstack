package org.scoula.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {
    @GetMapping("/") // getMap("/", ::home)을 해주는 annotation
    public String home() {
        log.info("================> HomeController /"); // build.gradle에서 logging 설정을 해줘야 사용가능
        return "index"; // View의 이름
    }
}


