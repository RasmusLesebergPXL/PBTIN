CREATE OR REPLACE FUNCTION aantal_dienstjaren
(p_date IN DATE)
RETURN NUMBER
AS
	v_jaar NUMBER(2);
BEGIN
	v_jaar :=TRUNC(MONTHS_BETWEEN(SYSDATE,p_date)/12);
	RETURN v_jaar;
END;
/

/* SELECT aantal_dienstjaren('15-AUG-87')
FROM dual; */