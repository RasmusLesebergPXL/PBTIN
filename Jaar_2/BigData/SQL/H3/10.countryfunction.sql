CREATE OR REPLACE PROCEDURE countryfunction
	(p_country_id IN countries.country_id%type)
AS
BEGIN
	FOR loc IN (SELECT country_name, location_id, city, COUNT(department_id) as departments
		FROM locations
		JOIN departments
		USING (location_id)
		JOIN countries
		USING (country_id)
		WHERE UPPER(country_id) = UPPER(p_country_id)
		GROUP BY country_name, location_id, city
		ORDER BY city)
	LOOP			
		IF (loc.departments > 0 ) THEN
			DBMS_OUTPUT.PUT_LINE('==> ' || loc.country_name ||'- '|| loc.location_id ||' ' || loc.city);
		END IF;

		FOR dep IN (SELECT department_name, COUNT(*) AS count
			FROM employees
			JOIN departments
			USING (department_id)
			JOIN locations
			USING (location_id)
			WHERE location_id = loc.location_id
			GROUP BY department_name
			ORDER BY count ASC)
		LOOP
			DBMS_OUTPUT.PUT_LINE(dep.department_name ||': '|| dep.count ||' werknemers');	
		END LOOP;
	END LOOP;
END countryfunction;
/

REM sta .\H3\10.countryfunction.sql    exec countryfunction('US')