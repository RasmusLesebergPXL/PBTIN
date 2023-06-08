CREATE OR REPLACE PROCEDURE club_leden
	(p_clubid	IN	NUMBER)
IS
    v_leden         NUMBER(10);
    v_totaal_clubs  NUMBER(10);
    v_totaal_leden  NUMBER(10);
BEGIN
    -- v_leden := aantal_leden(p_clubid);
    IF p_clubid = 0 THEN
    FOR allc IN (SELECT club_id, clubname FROM clubs)
        LOOP
            DBMS_OUTPUT.PUT_LINE('Club: ' || allc.club_id || ' ' || allc.clubname);

            FOR lid IN (SELECT member_id, firstname, lastname, club_id
                    FROM members
                    JOIN clubs
                    USING (club_id))
            LOOP
                DBMS_OUTPUT.PUT_LINE('--> ' || lid.member_id || ' ' || lid.firstname || ' ' ||  lid.lastname);
            END LOOP;
            DBMS_OUTPUT.PUT_LINE(chr(10));
        END LOOP;
        -- DBMS_OUTPUT.PUT_LINE('Aantal leden: ' || v_leden);
    ELSE
    FOR club IN (SELECT club_id, clubname FROM clubs
                WHERE club_id = p_clubid)
        LOOP
            DBMS_OUTPUT.PUT_LINE('Club: ' || club.club_id || ' ' || club.clubname);

            FOR lid IN (SELECT member_id, firstname, lastname, club_id
                    FROM members
                    JOIN clubs
                    USING (club_id)
                    WHERE club_id = p_clubid)
            LOOP
                DBMS_OUTPUT.PUT_LINE('--> ' || lid.member_id || ' ' || lid.firstname || ' ' ||  lid.lastname);
            END LOOP;
            DBMS_OUTPUT.PUT_LINE(chr(10));
        END LOOP;
        -- DBMS_OUTPUT.PUT_LINE('Aantal leden: ' || v_leden);
    END IF;

    -- EXTRA

    SELECT count(*)
    INTO v_totaal_clubs
    FROM clubs;
    DBMS_OUTPUT.PUT_LINE('Totaal aantal clubs: ' || v_totaal_clubs);

    SELECT count(*)
    INTO v_totaal_leden
    FROM members;
    DBMS_OUTPUT.PUT_LINE('Totaal aantal leden in de database: ' || v_totaal_leden);

END club_leden;
/