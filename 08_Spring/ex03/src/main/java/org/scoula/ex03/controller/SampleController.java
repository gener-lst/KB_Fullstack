package org.scoula.ex03.controller;

import lombok.extern.log4j.Log4j;
import org.scoula.ex03.dto.SampleDTO;
import org.scoula.ex03.dto.SampleDTOList;
import org.scoula.ex03.dto.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping("/sample")
@Log4j
public class SampleController {
    @RequestMapping("") // url: /sample
    public void basic() {
        log.info("basic......");
    }

    // GET과 POST 두 개 모두 처리하는 메소드
    // localhost:8080/sample/basic
    @RequestMapping(value="/basic", method = {RequestMethod.GET, RequestMethod.POST}) // url: /sample/basic
    public void basicGet() {
        log.info("basic get......");
    }

    @GetMapping("/basicOnlyGet")  // url: /sample/basicOnlyGet
    public void basicGet2() {
        log.info("basic get only get............");
    }

    @GetMapping("/ex01")
    public String ex01(SampleDTO dto) { // DI 요청 -> spring이 어떻게 만들어주는가? ~> 요청을 통한 DTO 객체 생성
        log.info("" + dto);
        // 넣어준 값이 없을 경우 초기값으로 나온다.
        return "ex01"; // view의 이름
    }

//    @RequestParam은 DTO 객체를 안 쓰고 각각 파라미터를 받아줄 때 사용
//    필드 두 개 다 제대로 안 넣어주면 예외 발생, 개별 파라미터는 뷰로 전달 불가능
    @GetMapping("/ex02")
    public String ex02(
            @RequestParam("name") String name,
            @RequestParam("age") int age
    ) {
        log.info("name: " + name);
        log.info("age: " + age);

        return "ex02";
    }
//    http://localhost:8080/sample/ex03?title=test&dueDate=2023/01/01
    @GetMapping("/ex03")
    public String ex03(TodoDTO todo) {
        log.info("todo: " + todo);

        return "ex03";
    }

//
//    page를 기본 자료형으로 넘기면 뷰로 전달되지 않는다
//    따라서 @ModelAttribute로 전달해야 한다 (request scope 저장)
    @GetMapping("/ex04")
    public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
        log.info("dto: " + dto);
        log.info("page: " + page);

        return "sample/ex04";
    }

//    http://localhost:8080/sample/ex04?name=aaa&age=11&page=9
//    같은 이름으로 여러 번 전달하는 경우 List나 배열로 받아올 수 있다.
//    localhost:8080/sample/ex02List
    @GetMapping("/ex01List")
    public String ex01List(@RequestParam("ids") ArrayList<String> ids) {
        log.info("ids: " + ids);

        return "ex01List";
    }

    @GetMapping("/ex02List")
    public String ex02List(@RequestParam("ids") String[] ids) {
        log.info("array ids: " + Arrays.toString(ids));

        return "ex02List";
    }

    @GetMapping("/ex02Bean")
    public String ex02Bean(SampleDTOList list) {
        log.info("list dtos: " + list);

        return "ex02Bean";
    }
}
