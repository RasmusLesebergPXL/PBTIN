CREATE OR REPLACE FUNCTION bereken_bruto
(p_empid employees.employee_id%type)
RETURN NUMBER
IS
	v_salary employees.salary%type;
	v_commission employees.commission_pct%type;
	v_jaarsal employees.salary%type;
BEGIN	
	SELECT salary, commission_pct
	INTO v_salary, v_commission
	FROM employees
	WHERE employee_id = p_empid;
	
    	v_jaarsal := ROUND(v_salary * 12 + (12*v_salary*NVL(v_commission, 0)),2);
	RETURN v_jaarsal;
END;
/