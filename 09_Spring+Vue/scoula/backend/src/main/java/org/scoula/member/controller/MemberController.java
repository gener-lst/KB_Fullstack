package org.scoula.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scoula.common.util.UploadFiles;
import org.scoula.member.dto.MemberDTO;
import org.scoula.member.dto.MemberJoinDTO;
import org.scoula.member.dto.MemberUpdateDTO;
import org.scoula.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {
    final MemberService service;

    // @PathVariable : 경로 상의 username을 변수 처리(이름 일치해야 함)
    @GetMapping("/checkusername/{username}")
    public ResponseEntity<Boolean> checkUsername(@PathVariable String username) {
        // 주어진 사용자 이름의 중복 여부를 체크하고 결과를 ResponseEntity로 반환
        return ResponseEntity.ok().body(service.checkDuplicate(username));
    }

    @PostMapping("") // avatar 이미지 때문에 multipart 인코딩으로 됨
    public ResponseEntity<MemberDTO> join(MemberJoinDTO member) {
        return ResponseEntity.ok(service.join(member));
    }
    // 회원 가입을 처리하고 가입된 회원 정보를 ResponseEntity로 변환

    @GetMapping("/{username}/avatar")
    public void getAvatar(@PathVariable String username, HttpServletResponse response) {
        String avatarPath = "c:/upload/avatar/" + username + ".png"; // 이미지 경로 생성
        File file = new File(avatarPath);
        if(!file.exists()) { // 아바타 등록이 없는 경우, 디폴트 아바타 이미지 사용
            file = new File("C:/upload/avatar/unknown.png");
        }
        UploadFiles.downloadImage(response, file);
    }

    // 회원 프로필 변경 요청을 처리하는 메소드
    @PutMapping("/{username}")
    public ResponseEntity<MemberDTO> changeProfile(MemberUpdateDTO member) {
        // DTO 객체를 통째로 받아서 그 안의 username을 경로 변수로 넘겨준다
        return ResponseEntity.ok(service.update(member));
    }
}
