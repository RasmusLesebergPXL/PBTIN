CREATE OR REPLACE PROCEDURE countryfunction
	(p_country_id IN countries.country_id%type)
AS
	v_location_id		VARCHAR2(50);
BEGIN

	FOR rec IN (SELECT country_name, location_id, city
		FROM locations
		JOIN countries
		USING (country_id)
		WHERE UPPER(country_id) = UPPER(p_country_id)
	LOOP
		DBMS_OUTPUT.PUT_LINE('==> ' || rec.country_name ||'- '|| rec.location_id ||' ' || rec.city);
	END LOOP;
END countryfunction;
/