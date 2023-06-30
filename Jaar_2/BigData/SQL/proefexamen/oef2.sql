CREATE OR REPLACE PROCEDURE rescount
	(p_maand	IN	NUMBER
	,p_jaar 	IN	NUMBER)
IS
BEGIN
	FOR voors IN (SELECT theatre_performance, date_time
        FROM performance_dates
        WHERE TO_CHAR(date_time, 'MON') = TO_CHAR(TO_DATE(p_maand, 'MM'), 'MON')
        AND TO_CHAR(p_jaar) = TO_CHAR(date_time, 'YYYY')
        ORDER BY date_time)
    LOOP
        DBMS_OUTPUT.PUT_LINE(voors.theatre_performance || ' ' || voors.date_time);

        FOR res IN (SELECT reservation_id, date_time, COUNT(*) AS count
            FROM reservation_performances
            JOIN performance_dates
            USING (date_time)
            JOIN reservations
            USING (reservation_id)
            JOIN subscribers
            USING (subscriber_id)
            WHERE voors.date_time = date_time
            GROUP BY reservation_id, date_time)
        LOOP
            DBMS_OUTPUT.PUT_LINE('--> reservation_id ' || res.reservation_id || ': ' || res.count || ' personen');
        END LOOP;
    END LOOP;
END rescount;
/
