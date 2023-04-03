DECLARE
	v_ster	VARCHAR2(50);
BEGIN
	asterisk_sal(100, v_ster);
	DBMS_OUTPUT.PUT_LINE(v_ster);
END;
/

/* VARIABLE b_ster VARCHAR2(50) <enter> exec asterisk_sal(100,:b_ster) */