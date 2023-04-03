CREATE OR REPLACE PROCEDURE minimumlonen
	(p_country	IN	countries.country_name%type
	,p_salary	IN	employees.salary%type)
IS
BEGIN
	UPDATE employees
	SET salary = p_salary
	WHERE department_id IN	(SELECT department_id
				FROM departments d
				JOIN locations l
				ON (l.location_id = d.location_id)
				JOIN countries c
				ON (c.country_id = l.country_id)
				WHERE LOWER(c.country_name) = LOWER(p_country)	
				AND salary < p_salary);
END minimumlonen;
/
