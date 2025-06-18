-- Query to Get the Second-Highest Salary in MySQL
-- Solution 1: use MAX function
SELECT MAX(salary) AS second_highest_salary
FROM employees
WHERE salary < (SELECT MAX(salary) FROM employees);
/*
How It Works
Inner query (SELECT MAX(salary) FROM employees) gets the highest salary: 70000.
Outer query filters out rows where salary < 70000, leaving 60000, 50000, 45000.
MAX(salary) on this filtered set gives 60000.
Pros
Simple and intuitive.
Handles duplicates (e.g., multiple 60000 entries don’t affect the result).
Cons
If there’s only one unique salary (e.g., all 50000), it returns NULL, which is fine but needs context.
*/

SELECT DISTINCT salary AS second_highest_salary
FROM employees
ORDER BY salary DESC
LIMIT 1 OFFSET 1;

/*
How It Works
DISTINCT salary removes duplicates: 70000, 60000, 50000, 45000.
ORDER BY salary DESC sorts them: 70000, 60000, 50000, 45000.
LIMIT 1 OFFSET 1 skips the first row (70000) and takes the next (60000).
Pros
Straightforward and readable.
Explicitly handles duplicates with DISTINCT.
Cons
If fewer than 2 unique salaries exist, it returns no rows (empty result set). You’d need a check for this case.
*/

