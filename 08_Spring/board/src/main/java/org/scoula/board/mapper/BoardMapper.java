package org.scoula.board.mapper;

import org.apache.ibatis.annotations.Select;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;

import java.util.List;

public interface BoardMapper {

//    @Select("select * from tbl_board order by no desc")
    public List<BoardVO> getList();

    public BoardVO get(Long no);
//
    public void create(BoardVO board);
//  기존에 있는 게시글을 업데이트(수정)
    public int update(BoardVO board);
//  해당 no 값을 가진 게시글을 삭제
    public int delete(Long no);
//  첨부 파일 생성
    public void createAttachment(BoardAttachmentVO attach);
//  해당 게시글 번호에 존재하는 첨부파일 목록 조회
    public List<BoardAttachmentVO> getAttachmentList(Long bno);
//  첨부파일 번호로 해당 파일 조회
    public BoardAttachmentVO getAttachment(Long no);
//  첨부파일 번호롤 해당 파일 삭제
    public int deleteAttachment(Long no);
}
