CREATE OR REPLACE PROCEDURE resspect
	(p_reservatie	IN	NUMBER)
IS
    v_resid     number(20);
    v_firstname VARCHAR2(50);
    v_name      VARCHAR(50);
BEGIN
    SELECT reservation_id, subscriber_firstname, subscriber_name
    INTO v_resid, v_firstname, v_name
    FROM reservations
    JOIN subscribers
    USING (subscriber_id)
    WHERE reservation_id = p_reservatie;

    DBMS_OUTPUT.PUT_LINE('Reservatie: ' || v_resid);
    DBMS_OUTPUT.PUT_LINE('Subscriber: ' || v_firstname || ' ' || v_name);
    DBMS_OUTPUT.PUT_LINE('Spectators:');

	FOR spect IN (SELECT spectator_firstname, spectator_name, reservation_id
        FROM spectators
        JOIN reservation_spectators
        USING (spectator_id)
        JOIN reservations
        USING (reservation_id)
        WHERE v_resid = reservation_id)
    LOOP
        IF spect.spectator_firstname NOT LIKE v_firstname THEN
            DBMS_OUTPUT.PUT_LINE('--> ' || spect.spectator_firstname || ' ' || spect.spectator_name);
        END IF;
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('Geboekte Performances:');

    FOR perf IN (SELECT theatre_performance, reservation_id, date_time
        FROM reservation_performances
        WHERE v_resid = reservation_id)
    LOOP
        DBMS_OUTPUT.PUT_LINE('--> ' || perf.theatre_performance || ' ' || TO_CHAR(perf.date_time, 'DD-MM-YYYY HH24:MI'));
    END LOOP;
END resspect;
/
