CREATE OR REPLACE PROCEDURE repetities
	(p_maand	IN	NUMBER
	,p_jaar 	IN	NUMBER)
IS
BEGIN
	FOR repetitie IN (SELECT theatre_performance, date_starttime
        FROM rehearsals
        WHERE TO_CHAR(date_starttime, 'MON') = TO_CHAR(TO_DATE(p_maand, 'MM'), 'MON')
        AND TO_CHAR(p_jaar) = TO_CHAR(date_starttime, 'YYYY')
        ORDER BY date_starttime)
    LOOP
        DBMS_OUTPUT.PUT_LINE(repetitie.theatre_performance || ' ' || repetitie.date_starttime);

        FOR act IN (SELECT actor_name, actor_firstname, date_starttime
            FROM actors
            JOIN rehearsal_actors
            USING (actor_id)
            WHERE repetitie.date_starttime = date_starttime)
        LOOP
            DBMS_OUTPUT.PUT_LINE('--> ' || act.actor_name || ' ' || act.actor_firstname);
        END LOOP;
    END LOOP;
END repetities;
/
