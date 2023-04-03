CREATE OR REPLACE FUNCTION manager_teruggave
RETURN VARCHAR2
IS
	v_departmentid employees.department_id%type;
	v_manager_first employees.first_name%type;
	v_manager_last employees.last_name%type;
	v_managerid employees.employee_id%type;
BEGIN
	SELECT department_id
	INTO v_departmentid
	FROM employees
	GROUP BY department_id
	HAVING COUNT(*) = 	(SELECT MAX(COUNT(*))
				FROM employees
				GROUP BY department_id);

	SELECT manager_id
	INTO v_managerid
	FROM departments
	WHERE department_id = v_departmentid;

	SELECT first_name, last_name
	INTO v_manager_first, v_manager_last
	FROM employees
	WHERE employee_id = v_managerid;

   RETURN v_manager_first || ' ' || v_manager_last;
END;
/
