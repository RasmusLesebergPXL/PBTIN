CREATE OR REPLACE TRIGGER aur_emp_sal
AFTER UPDATE OF salary
ON employees
FOR EACH ROW
WHEN (OLD.hire_date < TO_DATE('01-01-1995', 'dd-mm-yyyy'))
BEGIN
	IF (:NEW.salary - :OLD.salary > 0.05*:OLD.salary) THEN
		RAISE_APPLICATION_ERROR(-20000, 'salary te veel verhoogd');

	ELSIF (:NEW.salary < :OLD.salary) THEN
		RAISE_APPLICATION_ERROR(-20000, 'salary verlaging mag niet');	
	END IF;
END;
/