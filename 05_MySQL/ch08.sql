-- drop database if exists tabledb; 
-- create database tabledb;

-- drop table if exists userTbl; 
CREATE table userTbl (
	userID char(8) not null primary key,
    name varchar(10) not null,
    birthYaer int not null,
    addr char(2) not null,
    mobile1 char(3) null,
    mobile char(8) null,
    height smallint	null,
    mDate date null
);

-- drop table if exists buyTbl;
CREATE table buyTbl(
	num int auto_increment not null primary key,
	userID char(8) not null,
	prodName char(6) not null,
	groupName char(4),
	price int not null,
	amount smallint not null,
-- foreign key(해당 키) reference 참조할 테이블(참조할 키)
	foreign key(userID) references usertbl(userID)
);

-- 회원 테이블에 데이터를 입력하세요
insert into usertbl value('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-8-8');
insert into usertbl value('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-4-4');
insert into usertbl value('KKH', '김경호', 1971, '전남', '019', '3333333', 177, '2007-7-7');

-- 구매 테이블에 데이터를 입력하세요
insert into buytbl value(null,'KBS', '운동화', null, 30, 2);
insert into buytbl value(null, 'KBS', '노트북', '전자', 1000, 1);
-- 외래키 제약 조건 에러 발생 : 참조하고 있는 usertbl의 userID에 'JYP'라는 데이터가 없으므로 발생
insert into buytbl value(null, 'JYP', '모니터', '전자', 200, 1);

-- userTbl의 기본 키인 userID열은 buyTbl에 외래 키로 연결되어 있기 때문에 외래 키를 제거한 후에 다시 기본 키를 제거해야함 

alter table buyTbl drop foreign key buytbl_ibfk_1;
drop table if exists userTbl;

create table userTbl(
	userID char(8) not null,
    name varchar(10) not null,
    birthyear int not null,
	-- constraint primary key : 기본키 제약조건
    -- 제약조건 명은 생략 가능, 순서도 바뀌어도 괜찮음
    constraint primary key PK_userTBL_userID(userID)
);

drop table if exists pordTbl;

create table prodTbl(
	prodCode char(3) not null,
    prodID char(4) not null,
    prodDate date not null,
    prodCur char(10),
    -- 제약조건명은 생략 가능
    -- prodCode와 prodID 컬럼을 합쳐서 복합키로 기본키를 만듬
    constraint PK_prodTbl_proCode_prodID primary key (prodCode, prodID)
);