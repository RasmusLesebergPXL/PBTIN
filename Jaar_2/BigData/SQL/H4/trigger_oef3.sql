CREATE OR REPLACE TRIGGER bud_empsal
BEFORE UPDATE of salary OR DELETE
ON employees
DECLARE
BEGIN
	IF UPDATING THEN
		IF 	TO_CHAR(SYSDATE, 'DY') = 'MON' OR
			TO_CHAR(SYSDATE, 'hh24:mi:ss') < '09:00:00' OR
		 	TO_CHAR(SYSDATE, 'hh24:mi:ss') > '17:00:00' THEN

			RAISE_APPLICATION_ERROR(-20000, 'Dit is niet toegestaan op dit tijdstip');
		END IF;

	ELSIF DELETING OR INSERTING THEN
		IF	TO_CHAR(SYSDATE, 'DY') IN ('SAT','SUN') THEN

			RAISE_APPLICATION_ERROR(-20000, 'Deze actie is niet toegestaan in het weekend');
		END IF;
	END IF;
END;
/
