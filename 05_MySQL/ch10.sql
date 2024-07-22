-- db 생성
create database jdbc_ex;

-- create user : 'jdbc_ex'라는 이름의 사용자 생성
-- identified by : 비밀번호를 'jdbc_ex'로 설정
create user 'jdbc_ex'@'%' identified by 'jdbc_ex';
-- grant ~ on : 권한 부여 명령어
-- all privileges : 모든 권한 부여
grant all privileges on jdbc_ex.* to 'jdbc_ex'@'%';
-- 권한 즉시 서버에 적용
flush privileges;    