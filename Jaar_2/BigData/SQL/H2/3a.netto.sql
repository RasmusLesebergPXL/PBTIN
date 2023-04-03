CREATE OR REPLACE FUNCTION netto
(p_bruto employees.salary%type)
RETURN VARCHAR2
AS
	v_salaris employees.salary%type;
BEGIN
	v_salaris :=p_bruto * 0.6;
	RETURN TO_CHAR(v_salaris, '99,999.00') || 'euro';
END;
/

/* SELECT netto(10000)
FROM dual = 6000;
FORMAT(@s,'#,0.0000')*/