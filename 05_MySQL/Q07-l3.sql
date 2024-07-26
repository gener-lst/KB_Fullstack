-- 현재 재직 중인 직원의 정보를 출력하세요.
select e.emp_no, e.first_name, e.last_name, t.title 
	from employees e
		inner join titles t
			on e.emp_no = t.emp_no;
            
-- 현재 재직 중인 직원 정보를 출력하세요.
select e.*, t.title, s.salary
	from employees e
		inner join titles t
			on e.emp_no = t.emp_no
		inner join salaries s
			on e.emp_no = s.emp_no
		where s.to_date = '9999.01.01'
        and t.to_date = '9999.01.01';
        
-- 현재 재직중인 직원의 정보를 출력하세요.
select e.emp_no, e.first_name, e.last_name, d.dept_name
	from employees e
		inner join dept_emp de
			on e.emp_no = de.emp_no
		inner join departments d
			on de.dept_no = d.dept_no
		order by emp_no;
        
-- 부서별 재직중인 직원의 수를 출력하세요.
select d.dept_no, d.dept_name, count(*) 
	from departments d
		inner join dept_emp de
			on d.dept_no = de.dept_no
		where de.to_date = '9999-01-01'
		group by d.dept_no
        order by d.dept_no;
        

-- 직원 번호가 10209 인 직원의 부서 이동 히스토리를 출력하세요
select e.emp_no, e.first_name, e.last_name, d.dept_name, de.from_date, de.to_date
	from employees e
		inner join dept_emp de
			on e.emp_no = de.emp_no
		inner join departments d
			on de.dept_no = d.dept_no
		where e.emp_no = 10209
		order by de.to_date;