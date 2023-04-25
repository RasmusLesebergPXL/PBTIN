CREATE OR REPLACE TRIGGER aur_emp_sal5
AFTER UPDATE OF salary
ON employees
FOR EACH ROW
BEGIN
	IF (:NEW.salary - :OLD.salary > 0.05*:OLD.salary) THEN
		RAISE_APPLICATION_ERROR(-20000, 'salary te veel verhoogd');

	ELSIF (:NEW.salary < :OLD.salary) THEN
		RAISE_APPLICATION_ERROR(-20000, 'salary verlaging mag niet');
	END IF;
END;
/