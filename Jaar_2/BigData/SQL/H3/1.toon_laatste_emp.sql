CREATE OR REPLACE PROCEDURE toon_laatste_emp
IS 
	v_hire_date	employees.hire_date%type;
	v_emp_id	employees.employee_id%type;
	v_last_name	employees.last_name%type;
	v_first_name	employees.first_name%type;
	
BEGIN
	SELECT last_name, first_name, employee_id, hire_date
	INTO v_last_name, v_first_name, v_emp_id, v_hire_date
	FROM employees
	WHERE hire_date = 	(SELECT MAX(hire_date)
				FROM employees);

	DBMS_OUTPUT.PUT_LINE(v_first_name || ' ' || v_last_name || ' ' || v_emp_id || ' ' || v_hire_date);
END;
/