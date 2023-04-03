CREATE OR REPLACE FUNCTION volgende_vergadering
(p_date IN VARCHAR2)
RETURN DATE
AS
	v_vergadering DATE;
BEGIN
	v_vergadering := NEXT_DAY(LAST_DAY(p_date), 'MONDAY');
	
	IF  TO_CHAR(v_vergadering, 'DD/MM') IN ('01/04', '01/05') THEN
		v_vergadering := v_vergadering + 1;
	END IF;
	RETURN v_vergadering;
END;
/


/* SELECT volgende vergadering('15-OCT-2009')
FROM dual; */