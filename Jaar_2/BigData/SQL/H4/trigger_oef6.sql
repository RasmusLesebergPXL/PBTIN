CREATE OR REPLACE TRIGGER buir_emp_jobid
BEFORE UPDATE OR INSERT 
ON employees
FOR EACH ROW
BEGIN
	:NEW.last_name := INITCAP(:NEW.last_name);
	:NEW.first_name := INITCAP(:NEW.first_name);
	:NEW.job_id := UPPER(:NEW.job_id);
	
	IF INSERTING AND :NEW.hire_date < SYSDATE THEN
		RAISE_APPLICATION_ERROR(-20000, 'hire_date mag niet in het verleden zijn');
	END IF;
	IF UPDATING AND (:NEW.job_id LIKE '%MAN%' OR :NEW.job_id LIKE '%MGR%' AND :OLD.job_id NOT IN ('AD_PRES', 'AD_VP')) THEN
		:NEW.salary := :OLD.salary*1.05;
	END IF;
END;
/