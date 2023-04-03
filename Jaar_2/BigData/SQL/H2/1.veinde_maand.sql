CREATE OR REPLACE FUNCTION dagen_einde_maand
RETURN NUMBER
IS 
	v_dagen NUMBER(2);
BEGIN
	v_dagen :=LAST_DAY(SYSDATE)-SYSDATE;
	RETURN v_dagen;
END;
/

/* in terminal: sta opg1
SELECT dagen_einde_maand
FROM dual; */
