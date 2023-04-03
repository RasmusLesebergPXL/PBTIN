CREATE OR REPLACE FUNCTION get_jubileumdatum
(p_firstname employees.last_name%type, p_lastname employees.last_name%type)
RETURN VARCHAR2
IS
	v_hiredate 	employees.hire_date%type;
	v_jubileumdate 	employees.hire_date%type;
BEGIN
	SELECT hire_date
	INTO v_hiredate
	FROM employees
	WHERE UPPER(last_name) = UPPER(p_lastname)
	AND UPPER(first_name) = UPPER(p_firstname);

	IF TO_CHAR(ADD_MONTHS(v_hiredate, 12*25), 'Day') = 'FRIDAY' 
	   AND ADD_MONTHS(v_hiredate, 12*25) < sysdate THEN
		v_jubileumdate := ADD_MONTHS(v_hiredate, 12*25);
	ELSIF
		ADD_MONTHS(v_hiredate, 12*25) < sysdate THEN
		RETURN 'werd reeds gevierd';
	ELSE
		v_jubileumdate := NEXT_DAY(ADD_MONTHS(v_hiredate, 12*25), 'FRIDAY');		
	END IF;
	RETURN v_jubileumdate;	
END;
/

/*SELECT get_jubileumdatum('James', 'Landry') FROM dual; Answer = 19 jan 24 */