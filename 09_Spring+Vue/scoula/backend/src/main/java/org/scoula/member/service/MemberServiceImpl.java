package org.scoula.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scoula.member.dto.ChangePasswordDTO;
import org.scoula.member.dto.MemberDTO;
import org.scoula.member.dto.MemberJoinDTO;
import org.scoula.member.dto.MemberUpdateDTO;
import org.scoula.member.exception.PasswordMissmatchException;
import org.scoula.member.mapper.MemberMapper;
import org.scoula.security.account.domain.AuthVO;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    final PasswordEncoder passwordEncoder;
    final MemberMapper mapper;

    @Override
    public boolean checkDuplicate(String username) {
        MemberVO member = mapper.findByUsername(username);
        return member != null ? true : false;
    }

    @Override
    public MemberDTO get(String username) {
        // 주어진 사용자 이름으로 회원 정보 조회, 없으면 예외 발생
        MemberVO member = Optional.ofNullable(mapper.get(username))
                .orElseThrow(NoSuchElementException::new);
        return MemberDTO.of(member); // 회원 정보를 DTO로 변환하여 반환
    }

    private void saveAvatar(MultipartFile avatar, String username) {
    // 아바타 업로드
        if(avatar != null && !avatar.isEmpty()) { // avatar가 존재하는 경우에만
            File dest = new File("c:/upload/avatar", username + ".png");
            try {
                avatar.transferTo(dest); // 해당 경로에 파일 저장
            } catch (IOException e) {
                throw new RuntimeException(e); // advice에서 일괄 처리
            }
        }
    }

    @Transactional
    @Override
    public MemberDTO join(MemberJoinDTO dto) {
        MemberVO member = dto.toVO();
        member.setPassword(passwordEncoder.encode(member.getPassword())); // 비밀번호 암호화 -> 검사를 위해서는 matches() 메서드를 사용해야 함
        mapper.insert(member); // 테이블 쪽에 회원 정보 저장

        // 기본 회원 권한 설정 및 저장
        AuthVO auth = new AuthVO();
        auth.setUsername(member.getUsername());
        auth.setAuth("ROLE_MEMBER");
        mapper.insertAuth(auth); // 테이블쪽에 권한 정보 저장

        // 해당 유저의 아바타 이미지 저장
        saveAvatar(dto.getAvatar(), member.getUsername());

        return get(member.getUsername()); // 저장된 회원 정보 반환
    }

    @Override
    public MemberDTO update(MemberUpdateDTO member) {
        MemberVO vo = mapper.get(member.getUsername()); // 사용자 이름을 테이블에서 조회하여 MemberVO 객체에 저장
        if(!passwordEncoder.matches(member.getPassword(), vo.getPassword())) { // 비밀번호 일치 확인(암호화된 비밀번호 비교를 위해 matches() 사용)
            throw new PasswordMissmatchException(); // 비밀번호 불일치 시 예외 발생
        }
        // 업데이트할 정보를 DB에 반영
        mapper.update(member.toVO());
        // 새로운 아바타 저장
        saveAvatar(member.getAvatar(), member.getUsername());
        // 업데이트된 회원 정보 반환
        return get(member.getUsername());
    }

    @Override
    public void changePassword(ChangePasswordDTO changePassword) {
        // 사용자의 비밀번호를 가져오기 위해서 DB에서 사용자 정보 조회
        MemberVO member = mapper.get(changePassword.getUsername()); // VO는 DB 테이블과 일치해야 함
        // 입력된 이전 비밀번호와 DB에 저장된 비밀번호가 일치하는지 확인
        if(!passwordEncoder.matches(changePassword.getOldPassword(), member.getPassword())) {
            // 일치하지 않으면 비밀번호 불일치 예외 발생
            throw new PasswordMissmatchException();
        }
        // 새로운 비밀번호를 암호화하여 DTO에 설정
        changePassword.setNewPassword(passwordEncoder.encode(changePassword.getNewPassword()));
        mapper.updatePassword(changePassword);
    }
}
