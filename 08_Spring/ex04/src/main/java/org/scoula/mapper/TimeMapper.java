package org.scoula.mapper;

import org.apache.ibatis.annotations.Select; // mybatis의 이전 버전 이름이 ibatis

public interface TimeMapper {
//    @Select 어노테이션을 사용해서 SQL문을 직접 지정
    @Select("SELECT sysdate()")
    public String getTime();
//    데이터베이스에서 현재 시스템의 날짜와 시간 변환
    public String getTime2();
}
