package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.scoula.common.util.UploadFiles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Controller // bean 등록
@Log4j
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    final private BoardService service;

    @GetMapping("/list")
    public void list(Model model) {
        log.info("list");
        model.addAttribute("list", service.getList());
    }

    @GetMapping("/create")
    public void create() {
        log.info("create");
    }

    @PostMapping("/create")
    public String create(BoardDTO board) {
        log.info("create: " + board);
        service.create(board);
        return "redirect:/board/list";
    }

    @GetMapping({ "/get", "/update" }) // "/get"과 "/update" 경로를 둘 다 처리
//    @RequestParam : 주소 뒤에 ?를 붙여서 쿼리스트링으로 정보를 받아준다.
    public void get(@RequestParam("no") Long no, Model model) {
        log.info("/get or update");
//        model 객체는 데이터를 뷰로 전달하기 위해 사용
        model.addAttribute("board", service.get(no));
    }

    @PostMapping("/update")
    public String update(BoardDTO board) {
        log.info("update:" + board);
        service.update(board);

    // 수정한 후 목록 페이지로 리다이렉트
        return "redirect:/board/list";
    }

    @PostMapping("/delete")
    // ("no")은 생략 가능
    public String delete(@RequestParam("no") Long no, RedirectAttributes ra) {
        if (service.delete(no)) {
            ra.addFlashAttribute("result", "success");
        }

//        수정한 후 목록 페이지로 리다이렉트
        return "redirect:/board/list";
    }

    @GetMapping("/download/{no}")
    @ResponseBody // view를 사용하지 않고, 직접 내보냄
    public void download(@PathVariable("no") Long no, HttpServletResponse response) throws Exception {
        BoardAttachmentVO attach = service.getAttachment(no);
        File file = new File(attach.getPath());
        UploadFiles.download(response, file, attach.getFilename());
    }
}