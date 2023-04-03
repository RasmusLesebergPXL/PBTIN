CREATE OR REPLACE PROCEDURE country_dept
	(p_country_id IN countries.country_id%type)
AS
	v_count 	number := 0;
BEGIN
	FOR rec IN (SELECT department_id, department_name
		FROM departments d
		JOIN locations l
		ON (d.location_id = l.location_id)
		WHERE UPPER(l.country_id) = UPPER(p_country_id))	
	LOOP
		DBMS_OUTPUT.PUT_LINE(rec.department_id||' '||rec.department_name);
		v_count := v_count + 1;
	END LOOP;
	IF v_count = 0 THEN
		DBMS_OUTPUT.PUT_LINE('Er zijn geen departementen gevestigd in het land met id ' 
	   	   		     || p_country_id);
	END IF;
END country_dept;
/