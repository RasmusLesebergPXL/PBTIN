CREATE OR REPLACE TRIGGER bir_members
BEFORE INSERT
ON members
FOR EACH ROW

BEGIN
    IF (TO_CHAR((SYSDATE - :NEW.birthday),'YY') IN('1,2')) THEN
    	RAISE_APPLICATION_ERROR(-20000, 'Je moet minstens 3 jaar zijn om je te kunnen inschrijven');
    END IF;
END;
/