use sqldb;
select * from usertbl;
show index from usertbl;
show table status like 'usertbl';

-- usertbl의 addr 컬럼에 대해 idx_usertbl_addr 이름으로 인덱스를 만들고,인덱스 목록을 확인하세요.
create index idx_usertbl_addr 
on usertbl(addr);
show index from usertbl;

-- usertbl의 상태를 출력하여 인덱스의 내용이 만들어졌는지 확인하고, 내용이 없다면 실제 적용되도록 한 후, 인덱스의 크기를 확인하세요
show table status like 'usertbl';
analyze table usertbl;

-- usertbl에 대해 다음을 처리하세요.
create unique index idx_usertbl_name
on usertbl(name);

show index from usertbl;

drop index idx_usertbl_name on usertbl;

create unique index idx_usertbl_name_birthYear
on usertbl(name, birthYear);

show index from usertbl;

drop index idx_usertbl_name_birthYear on usertbl;