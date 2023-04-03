CREATE OR REPLACE PROCEDURE landenlijst
AS
	v_count		number(2) := 0;
BEGIN
	FOR rec IN 	(SELECT country_name
			FROM countries)	
	LOOP
		DBMS_OUTPUT.PUT_LINE(rec.country_name);
		v_count := v_count + 1;
	END LOOP;
	DBMS_OUTPUT.PUT_LINE('We hebben connecties in ' || v_count || ' landen');
END landenlijst;
/