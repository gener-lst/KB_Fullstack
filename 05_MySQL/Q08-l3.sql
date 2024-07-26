-- 다음 정보를 가지는 직원 정보를 출력하는 EMPLOYEES_INFO 뷰를 작성하세요
create view employees_info
as 
	select e.emp_no, e.birth_date, e.first_name, e.last_name, e.gender, e.hire_date
		, t.title, t.from_date as t_from, t.to_date as t_to, s.salary, s.from_date as s_from, s.to_date as s_to
			from employees e
				inner join titles t
					on e.emp_no = t.emp_no
				inner join salaries s
					on e.emp_no = s.emp_no;

-- EMPLOYEES_INFO 뷰에서 재직자의 현재 정보만 출력하세요
select * from employees_info where t_to = '9999-01-01' and s_to = '9999-01-01';

-- 다음 정보를 가지는 부서 정보를 출력하는 EMP_DEPT_INFO 뷰를 작성하세요
create view emp_dept_info 
as 
	select de.emp_no, de.dept_no, d.dept_name, de.from_date, de.to_date 
		from departments d
			inner join dept_emp de
				on d.dept_no = de.dept_no
			order by de.emp_no;
                
-- EMP_DEPT_INFO로 현재 재직자의 부서 정보를 출력하세요
select * 
	from emp_dept_info
    where to_date = '9999-01-01';
