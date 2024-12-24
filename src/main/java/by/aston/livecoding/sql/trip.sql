--Отображать имена людей, имеющих среди пассажиров полных тезок
SELECT name
FROM passenger p
GROUP by p.name
HAVING count(p.id) > 1

--Выведите пассажиров с самым длинным полным именем. Пробелы, дефисы и точки считаются частью имени.
SELECT p.name
FROM passenger p
ORDER BY LENGTH(p.name) DESC
limit 1