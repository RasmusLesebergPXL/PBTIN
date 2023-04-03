CREATE OR REPLACE FUNCTION next_employee_id
RETURN NUMBER
AS
	new_emp_id NUMBER(4);
BEGIN
  	SELECT MAX(employee_id) + 1 
  	INTO new_emp_id 
	FROM employees;
  RETURN new_emp_id;
END;
/