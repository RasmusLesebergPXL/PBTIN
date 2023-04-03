SELECT TO_CHAR(hire_date, 'YYYY') as JAAR, 
	COUNT(last_name) as AANTAL
FROM employees e
JOIN departments d
ON (d.department_id = e.department_id)
JOIN locations l
ON (l.location_id = d.location_id)
JOIN countries c
ON (c.country_id = l.country_id)
WHERE LOWER(c.Country_name) LIKE '%america%'
GROUP BY TO_CHAR(hire_date, 'YYYY')
ORDER BY TO_CHAR(hire_date, 'YYYY')
/