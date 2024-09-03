package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.scoula.common.pagination.Page;
import org.scoula.common.pagination.PageRequest;
import org.scoula.common.util.UploadFiles;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

@RestController // 모든 메소드에 @ResponseBody 추가해줌 -> 응답을 json으로 받아온다
@RequestMapping("/api/board") // 메소드들의 공통 url
@RequiredArgsConstructor // final이 붙은 필드로 생성자 만들어줌
@Slf4j // 로깅을 위한 어노테이션
public class BoardController {
    private final BoardService service;


    //    전체 게시글 조회
    //    http://localhost:8080/api/board
    @GetMapping("")
    public ResponseEntity<Page> getList(PageRequest pageRequest) {
        // 상태 코드가 200이고 body 타입이 Page인 응답 객체를 리턴
        return ResponseEntity.ok(service.getPage(pageRequest));
    }

    //    특정 게시글 조회
    //    http://localhost:8080/api/board/7
    @GetMapping("/{no}")
    public ResponseEntity<BoardDTO> get(@PathVariable Long no) {
//        상태 코드가 200이고 body 타입이 BoardDTO인 응답 객체를 리턴
        return ResponseEntity.ok(service.get(no));
    }

    //    http://localhost:8080/api/board
//    새 게시글 생성
    @PostMapping()
    public ResponseEntity<BoardDTO> create(BoardDTO board) {
//        객체를 json 데이터 형태로 보낼 때는 @RequestBody 사용
//        POST 요청시 대부분 사용한다
        return ResponseEntity.ok(service.create(board));
    }

    //    http://localhost:8080/api/board/14
//    기존 게시글 수정
    @PutMapping("/{no}")
    public ResponseEntity<BoardDTO> update(@PathVariable Long no, BoardDTO board) {
//        no 번호의 게시글을 @RequestBody에 담아온 데이터로 수정
//        mapper.xml 부분의 #{ } 내에 있는 필드 값은 꼭 @RequestBody 에 추가해줄것
//        소문자로 시작하는 primitive 타입은 null 값이 들어가면 예외 발생하기 때문에
//                되도록이면 대문자로 시작하는 wrapper 객체 사용 권장 (int -> Long)
//        @PathVariable 변수 이름이 경로와 다를 경우 @PathVariable("no") Long id 와 같이 이름 명시 필요
        return ResponseEntity.ok(service.update(board));
    }

    @DeleteMapping("/{no}")
    public ResponseEntity<BoardDTO> delete(@PathVariable Long no) {
        service.deleteAttachment(no);

        return ResponseEntity.ok(service.delete(no));
    }

    @GetMapping("/download/{no}")
    public void download(@PathVariable Long no, HttpServletResponse response) throws Exception {
        BoardAttachmentVO attachment = service.getAttachment(no);
        File file = new File(attachment.getPath());
        UploadFiles.download(response, file, attachment.getFilename());
    }

//    기존 게시글 삭제
    @DeleteMapping("/deleteAttachment/{no}")
    public ResponseEntity<Boolean> deleteAttachment(@PathVariable Long no) throws Exception {
        return ResponseEntity.ok(service.deleteAttachment(no));
    }
}

