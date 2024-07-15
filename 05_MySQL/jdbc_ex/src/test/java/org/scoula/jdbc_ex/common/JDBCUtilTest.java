package org.scoula.jdbc_ex.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class JDBCUtilTest {

    @Test
    @DisplayName("jdbc_ex에 접속합니다.")
    void getConnection() throws SQLException {
        // try 자동화로 connection을 자동 닫기 하기위해서 try 문 사용
        try (Connection connection = JDBCUtil.getConnection()){
            System.out.println("DB 연결 성공");
        } 
    }
}