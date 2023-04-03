CREATE OR REPLACE PROCEDURE asterisk_sal
	(p_emp_id IN employees.employee_id%type,
	p_asterisk OUT VARCHAR2)
AS
	v_count		number(3) := 0;
	v_salary	employees.salary%type;
BEGIN
	SELECT salary
	INTO v_salary
	FROM employees
	WHERE employee_id = p_emp_id;
	
	LOOP
		v_count:= v_count + 1;
		p_asterisk := p_asterisk || '*';
		EXIT WHEN v_count >= TRUNC(v_salary / 1000);
	END LOOP;
END asterisk_sal;
/
