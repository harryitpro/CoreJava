-- How do you find duplicate records in a table
SELECT email, COUNT(*) as count
FROM Employees
GROUP BY email
HAVING count > 1;

/*
output:
+-------------------+----------+
| email             | COUNT(*) |
+-------------------+----------+
| alice@example.com |        2 |
+-------------------+----------+
1 row in set (0.00 sec)
*/