-- Understanding SELECT 1 FROM employees in MySQL
SELECT 1 FROM employees WHERE salary > 50000;
/* Output:
+---+
| 1 |
+---+
| 1 |
| 1 |
| 1 |
| 1 |
+---+
Explanation: This only checks for the existence of rows where salary > 50000.
*/

-- Checking If a Record Exists
select 'Exists'
where exists (select 1 from employees where salary > 50000);
--Exists


