
    person
    id      name        pos_id
    1       Владимир    1
    2       Иван        3
    3       Александр   2

    positions
    id      title
    1       Дизайнер
    2       Тестировщик
    3       Разработчик

    получить результат в виде таблицы
    id      name        pos_title
    1       Владимир    Дизайнер
    2       Иван        Разработчик
    3       Александр   Тестировщик

select per.id, per.name, pos.title as pos_title from person as per inner join position as pos on per.pos_id = pos.id

