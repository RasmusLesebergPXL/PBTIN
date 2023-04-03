CREATE OR REPLACE FUNCTION schikkeljaar
RETURN VARCHAR2
AS
	v_schikkeljaar NUMBER(4);
BEGIN
	SELECT EXTRACT(YEAR FROM CURRENT_DATE) INTO v_schikkeljaar FROM dual;
	IF (MOD(v_schikkeljaar,4) = 0) AND (MOD(v_schikkeljaar,100) != 0) THEN
		RETURN 'Het jaar ' || v_schikkeljaar || ' is een schikkeljaar';
	ELSE
		RETURN 'Het jaar ' || v_schikkeljaar || ' is geen schikkeljaar';
	END IF;
END;
/


/* SELECT schikkeljaar
FROM dual;*/