CREATE OR REPLACE PROCEDURE loonsverhoging
	(p_department_id IN departments.department_id%type
	,p_loonverhoging IN NUMBER)
AS
	v_department_name	VARCHAR2(50);
BEGIN
	SELECT department_name
	INTO v_department_name
	FROM departments
	WHERE department_id = p_department_id;
	
	DBMS_OUTPUT.PUT_LINE('Het gekozen departement is:  ' || v_department_name);
	
	FOR rec IN (SELECT employee_id, last_name, salary
		FROM employees
		WHERE department_id = p_department_id)
	LOOP
		DBMS_OUTPUT.PUT_LINE(rec.employee_id||' '||rec.last_name||' '||rec.salary);
	END LOOP;

	UPDATE employees
	SET salary = salary + (salary * p_loonverhoging / 100)
	WHERE department_id = p_department_id;

	DBMS_OUTPUT.PUT_LINE('Aantal salarisverhogingen:  ' || SQL%ROWCOUNT);
END loonsverhoging;
/

/* exec opgave9(10,10): Het gekozen departement is: Administration, 200 Whalen: 4400 Aantal salarisverhogingen: ... */