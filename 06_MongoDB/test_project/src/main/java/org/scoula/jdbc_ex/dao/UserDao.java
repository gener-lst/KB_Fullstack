package org.scoula.jdbc_ex.dao;

import org.scoula.jdbc_ex.domain.UserVO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    int create(UserVO userVO) throws SQLException;
    int update(UserVO userVO) throws SQLException;
    int delete(String id) throws SQLException;
    Optional<UserVO> findById(String id) throws SQLException;
    List<UserVO> findAll() throws SQLException;
}

//// 회원 등록(CRUD 중 C)
//int create(UserVO user) throws SQLException;
//// 회원 목록 조회(CRUD 중 R)
//List<UserVO> getList() throws SQLException;
//// 회원 정보 조회(CRUD 중 R)
//Optional<UserVO> get(String id) throws SQLException;
//// 회원 수정(CRUD 중 U)
//int update(UserVO user) throws SQLException;
//// 회원 삭제(CRUD 중 D)
//int delete(String id) throws SQLException;