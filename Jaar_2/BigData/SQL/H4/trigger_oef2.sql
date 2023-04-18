CREATE OR REPLACE TRIGGER audis_jobh
AFTER UPDATE OR DELETE OR INSERT
ON job_history

DECLARE
	v_actie		VARCHAR2(50);
BEGIN
	IF DELETING THEN
		v_actie := 'DELETE';
	ELSIF UPDATING THEN
		v_actie := 'UPDATE';
	ELSE
		v_actie := 'INSERT';
	END IF;
	INSERT INTO log_history
	VALUES(USER, SYSDATE, SYSTIMESTAMP, v_actie);
END;
/