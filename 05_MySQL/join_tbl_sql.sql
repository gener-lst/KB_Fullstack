use sqldb;
create table stdtbl (
	stdName varchar(10) not null primary key,
    addr char(4) not null
);

create table clubtbl (
	clubName varchar(10) not null primary key,
    roomNo char(4) not null
);

create table stdclubtbl (
	num int auto_increment not null primary key,
	stdName varchar(10) not null,
    clubName varchar(10) not null,
    foreign key(stdName) references stdtbl(stdName),
    foreign key(clubName) references clubtbl(clubName)
);

insert into stdtbl values ('김범수', '경남'), ('성시경', '서울'), ('조용필', '경기'), ('은지원', '경북'), ('바비킴', '서울');
insert into clubtbl values ('수영', '101호'), ('바둑', '102호'), ('축구', '103호'), ('봉사', '104호');
insert into stdclubtbl values (null, '김범수', '바둑'), (null, '김범수', '축구'), (null, '조용필', '축구'),
	(null, '은지원', '축구'), (null, '은지원', '봉사'), (null, '바비킴', '봉사');

create table emptbl(emp char(3), manager char(3), empTel varchar(8));

insert into emptbl values('나사장', null, '0000');
insert into emptbl values('김재무', '나사장', '2222');
insert into emptbl values('김부장', '김재무', '2222-1');
insert into emptbl values('이부장', '김재무', '2222-2');
insert into emptbl values('우대리', '이부장', '2222-2-1');
insert into emptbl values('지사원', '이부장', '2222-2-2');
insert into emptbl values('이영업', '나사장', '1111');
insert into emptbl values('한과장', '이영업', '1111-1');
insert into emptbl values('최정보', '나사장', '3333');
insert into emptbl values('윤차장', '최정보', '3333-1');
insert into emptbl values('이주임', '윤차장', '3333-1-1');