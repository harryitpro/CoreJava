-- find employees who earn more than their managers
SELECT e.name as employee, e.salary, m.name as manager, m.salary
FROM employees e
JOIN employees m ON e.manager_id = m.id WHERE e.salary > m.salary;
/*
EXPLANATION:
1, INNER JOIN
    the same table of employees.
2, ON
   manager_id = id
3, WHERE clause
*/

/*
-- output
| employee    | salary   | manager       | salary   |
+-------------+----------+---------------+----------+
| Alice Brown | 85000.00 | Alice Johnson | 75000.00 |
*/