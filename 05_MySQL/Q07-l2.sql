-- q1
select s.stdName, s.addr, sc.clubName, c.roomNo 
	from stdtbl s
		inner join stdclubtbl sc
			on s.stdName = sc.stdName
		inner join clubtbl c
			on sc.clubName = c.clubName
		order by s.stdName;

-- q2
select sc.clubName, c.roomNo, sc.stdName, s.addr
	from stdclubtbl sc
		inner join stdtbl s
			on sc.stdName = s.stdName
		inner join clubtbl c
			on sc.clubName = c.clubName
		order by c.clubName;
        
-- q3
select r.emp, r.manager, l.empTel 
	from emptbl l
		inner join emptbl r
			on l.emp = r.manager
		where r.emp = '우대리';