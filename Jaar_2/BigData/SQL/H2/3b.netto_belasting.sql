CREATE OR REPLACE FUNCTION netto
(p_bruto employees.salary%type)
RETURN VARCHAR2
AS
	v_salaris employees.salary%type;
BEGIN
	IF p_bruto <=10000 THEN
		v_salaris:=p_bruto*0.6;
	ELSIF p_bruto <=16000 THEN
		v_salaris:=p_bruto*0.6+(p_bruto-10000)*0.5;
	ELSE
		v_salaris:=10000*0.6+6000*0.5+(p_bruto-16000)*0.4; 
	END IF;
RETURN TO_CHAR(v_salaris, '999,999.00') || 'euro';
END;
/

/* SELECT netto(18000)
FROM dual; expected answer = 9800
FORMAT(@s,'#,0.0000')*/