--Найдите максимальный возраст среди учеников 10-х классов сегодня.
--Чтобы получить текущую дату и время, вы можете использовать функцию NOW().
SELECT ROUND(DATEDIFF(CURDATE(), birthday) / 365) as max_year
FROM Student s
	join Student_in_class sic on s.id = sic.student
	join class c on sic.class = c.id
WHERE c.name like '10%'
order by max_year desc
LIMIT 1