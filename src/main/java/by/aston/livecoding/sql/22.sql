--1.Вывести название, жанр и цену тех книг, количество которых больше 8, в отсортированном по убыванию цены виде.
SELECT title, name_genre, price
FROM genre INNER JOIN book
ON genre.genre_id = book.genre_id
WHERE amount > 8
ORDER BY price DESC;

--2.Вывести все жанры, которые не представлены в книгах на складе.
select name_genre from genre
LEFT JOIN book
on genre.genre_id=book.genre_id
where book.genre_id is null;

--4. Вывести информацию о книгах (жанр, книга, автор), относящихся к жанру, включающему слово «роман» в отсортированном по названиям книг виде.
SELECT
 name_genre, title, name_author
FROM
    genre
    INNER JOIN book ON genre.genre_id = book.genre_id
    INNER JOIN author ON book.author_id = author.author_id
WHERE name_genre LIKE "Роман%"
ORDER BY title;

--6.Вывести в алфавитном порядке всех авторов, которые пишут только в одном жанре.
----Поскольку у нас в таблицах так занесены данные, что у каждого автора книги только в одном жанре,
----для этого запроса внесем изменения в таблицу book.
----Пусть у нас  книга Есенина «Черный человек» относится к жанру «Роман»,
----а книга Булгакова «Белая гвардия» к «Приключениям» (эти изменения в таблицы уже внесены).
SELECT name_author
FROM
    author INNER JOIN book
    on author.author_id = book.author_id
GROUP BY name_author
HAVING COUNT(DISTINCT genre_id) = 1
ORDER BY name_author ;

--7.Вывести информацию о книгах (название книги, фамилию и инициалы автора, название жанра,
--цену и количество экземпляров книги), написанных в самых популярных жанрах,
--в отсортированном в алфавитном порядке по названию книг виде.
--Самым популярным считать жанр, общее количество экземпляров книг которого на складе максимально.
SELECT  title, name_author, name_genre, price, amount
FROM
    author
    INNER JOIN book ON author.author_id = book.author_id
    INNER JOIN genre ON  book.genre_id = genre.genre_id
WHERE genre.genre_id IN
         (/* выбираем автора, если он пишет книги в самых популярных жанрах*/
          SELECT query_in_1.genre_id
          FROM
              ( /* выбираем код жанра и количество произведений, относящихся к нему */
                SELECT genre_id, SUM(amount) AS sum_amount
                FROM book
                GROUP BY genre_id
               )query_in_1
          INNER JOIN
              ( /* выбираем запись, в которой указан код жанр с максимальным количеством книг */
                SELECT genre_id, SUM(amount) AS sum_amount
                FROM book
                GROUP BY genre_id
                ORDER BY sum_amount DESC
                LIMIT 1
               ) query_in_2
          ON query_in_1.sum_amount= query_in_2.sum_amount
         )
ORDER BY title;

--8.Если в таблицах supply  и book есть одинаковые книги, которые имеют равную цену,  вывести их название и автора, а также посчитать общее количество экземпляров книг в таблицах supply и book,  столбцы назвать Название, Автор  и Количество.
SELECT title 'Название', name_author 'Автор', supply.amount+book.amount 'Количество' FROM book
INNER JOIN supply USING(title, price)
INNER JOIN author USING(author_id)

