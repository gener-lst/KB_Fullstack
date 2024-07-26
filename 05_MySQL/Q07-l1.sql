-- q1 
select * from usertbl u 
	inner join buytbl b
    on u.userID = b.userID
where b.amount > 0 and b.userID = 'JYP';

-- q2
select u.userID, u.name, b.prodName, u.addr, concat(u.mobile1, u.mobile2) as '연락처'
	from usertbl u
		left outer join buytbl b
		on u.userID = b.userID
	order by u.userID;

-- q3
select * from usertbl where concat(mobile1, mobile2) is not null;
-- q4
select * from usertbl where concat(mobile1, mobile2) is null;
