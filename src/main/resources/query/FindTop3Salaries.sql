-- get the top 3 salaries without duplicates
SELECT DISTINCT salary FROM employees
ORDER BY salary DESC
LIMIT 3