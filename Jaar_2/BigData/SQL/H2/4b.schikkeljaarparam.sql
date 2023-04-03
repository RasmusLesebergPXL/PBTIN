CREATE OR REPLACE FUNCTION schikkeljaar
(p_jaar IN NUMBER)
RETURN VARCHAR2
AS
	v_schikkeljaar NUMBER(4);
BEGIN
	IF (MOD(p_jaar,4) = 0) AND (MOD(p_jaar,100) != 0) THEN
		RETURN 'Het jaar ' || p_jaar || ' is een schikkeljaar';
	ELSE
		RETURN 'Het jaar ' || p_jaar || ' is geen schikkeljaar';
	END IF;
END;
/

/* SELECT schikkeljaar(2000)
FROM dual;
FORMAT(@s,'#,0.0000')*/