--1.Вывести к каждому самолету класс обслуживания и количество мест этого класса
SELECT model:: json ->> 'ru'        AS Модель,
       aircrafts_data.aircraft_code AS Код_самолёта,
       fare_conditions              AS Класс_обслуживания,
       count(fare_conditions)       AS Количество_мест
FROM aircrafts_data
         JOIN seats ON aircrafts_data.aircraft_code = seats.aircraft_code
GROUP BY fare_conditions, model, aircrafts_data.aircraft_code
ORDER BY model, seats.fare_conditions;

--2.Найти 3 самых вместительных самолета (модель + кол-во мест)
SELECT model:: json ->> 'ru' AS Модель,
       count(seats)          AS Количество_мест
FROM aircrafts_data
         JOIN seats ON aircrafts_data.aircraft_code = seats.aircraft_code
GROUP BY model
ORDER BY count(seats) DESC
LIMIT 3;

--3.Вывести код,модель самолета и места не эконом класса для самолета 'Аэробус A321-200' с сортировкой по местам
SELECT aircrafts_data.aircraft_code AS Код,
       model:: json ->> 'ru'        AS Модель,
       seat_no                      AS Места
FROM aircrafts_data
         JOIN seats ON aircrafts_data.aircraft_code = seats.aircraft_code
WHERE model:: json ->> 'ru' = 'Аэробус A321-200'
  AND seats.fare_conditions != 'Economy'
ORDER BY seat_no;

--4.Вывести города в которых больше 1 аэропорта ( код аэропорта, аэропорт, город)
SELECT airport_code                 AS Код_аэропорта,
       airport_name:: json ->> 'ru' AS Аэропорт,
       city :: json ->> 'ru'        as Город
FROM airports_data
WHERE city = ANY
      (SELECT city
       FROM airports_data
       GROUP BY city
       HAVING count(airport_code) >= 2);

--5.Найти ближайший вылетающий рейс из Екатеринбурга в Москву, на который еще не завершилась регистрация
SELECT flight_id           AS ID,
       flight_no           AS Номер_рейса,
       scheduled_departure AS План_вылета,
       scheduled_arrival   AS План_прибытия,
       concat(d.airport_name:: json ->> 'ru' || ' ' || departure_airport)
                           AS Аэропорт_вылета,
       concat(a.airport_name:: json ->> 'ru' || ' ' || arrival_airport)
                           AS Аэропорт_прибытия,
       status              AS Статус,
       concat(ad.model:: json ->> 'ru' || ' код ' || flights.aircraft_code)
                           AS Самолёт
FROM flights
         JOIN aircrafts_data ad on ad.aircraft_code = flights.aircraft_code
         JOIN airports_data a on a.airport_code = flights.arrival_airport
         JOIN airports_data d on d.airport_code = flights.departure_airport
WHERE departure_airport = ANY (SELECT airport_code
                               FROM airports_data
                               WHERE city:: json ->> 'ru' = 'Екатеринбург')
  AND arrival_airport = ANY (SELECT airport_code
                             FROM airports_data
                             WHERE city:: json ->> 'ru' = 'Москва')
  AND status IN ('Scheduled', 'On Time', 'Delayed')
ORDER BY scheduled_departure
LIMIT 1;

--6.Вывести самый дешевый и дорогой билет и стоимость ( в одном результирующем ответе)
SELECT ticket_no       AS Номер_билета,
       flight_id       AS Идентификатор_рейса,
       fare_conditions AS Класс_обслуживания,
       amount          AS Стоимость_перелета
FROM ticket_flights
WHERE concat(ticket_no, flight_id) = (SELECT concat(ticket_no, flight_id)
                                      FROM ticket_flights
                                      WHERE amount = ANY ((SELECT max(amount) FROM ticket_flights))
                                      LIMIT 1)
   OR concat(ticket_no, flight_id) = (SELECT concat(ticket_no, flight_id)
                                      FROM ticket_flights
                                      WHERE amount = ANY ((SELECT min(amount) FROM ticket_flights))
                                      LIMIT 1);

--7.Написать DDL таблицы Customers , должны быть поля id , firstName, LastName, email , phone. Добавить ограничения на поля ( constraints) .
create table if not exists customers
(
    id         bigserial
        constraint customers_pk
            primary key,
    first_name varchar(32) not null,
    last_name  varchar(32) not null,
    email      varchar(256) default 'test@test.by'::character varying,
    phone      varchar(13)
        constraint customers_pk2
            unique,
    constraint customers_pk3
        unique (first_name, last_name)
);

-- 8.Написать DDL таблицы Orders, должен быть id, customerId, quantity. Должен быть внешний ключ на таблицу customers + ограничения
create table if not exists orders
(
    id          bigserial
        constraint orders_pk
            primary key,
    customer_id integer
        constraint orders_customers_id_fk
            references customers,
    quantity    integer not null
);

-- 9. Написать 5 insert в эти таблицы
-- (Я написал по 10 штук)
insert into customers (id, first_name, last_name, email, phone)
values (1, 'Anton', 'Ptushkin', 'dwa@dwa.ua', '+123456789'),
       (2, 'Slava', 'Komissarenko', 'sdwae@dwaes.bbb', '+978567812'),
       (3, 'Petr', 'Ivanov', 'htd@htf.by', '+987654123'),
       (4, 'Dima', 'Smirnov', 'qwert@hmn.com', '+978567899'),
       (5, 'Vasiliy', 'Sidorov', 'wertyuj@dwa.ru', '+412345789'),
       (6, 'Fillip', 'Morris', 'fil@fil.bd', '+245678912'),
       (7, 'Dan', 'Brown', 'dan@bnm.by', '+410852963'),
       (8, 'Doug', 'De Muro', 'ddd@gehsj.by', '+456789123'),
       (9, 'Garik', 'Kharlamov', 'gar@gar.dwa', '+654321987'),
       (10, 'Maria', 'Markova', 'mar@mar.d', '+741852963');

insert into orders (id, customer_id, quantity)
values (1, 10, 9),
       (2, 1, 12),
       (3, 8, 3),
       (4, 7, 2),
       (5, 9, 6),
       (6, 3, 1),
       (7, 2, 12),
       (8, 1, 123),
       (9, 5, 5),
       (10, 4, 32);

-- удалить таблицы
drop table if exists orders;
drop table if exists customers;
-- (если customers удаляется перед удалением orders используем 'cascade')
drop table if exists customers cascade;
drop table if exists orders;


--кастомный запрос:
-- Найти билеты, запланированные на промежуток времени 01 августа 2017 года с 00:00 по 12:00,
-- для пассажиров бизнес класса с фамилиями, заканчивающимися на "...ОVА" (например POPOVA);
-- вывести ИМЯ/Фамилия/Телефон для связи с пассажирами.
SELECT substring(t.passenger_name FROM '.+ ')                                 AS Имя,
       substring(t.passenger_name FROM position(' ' IN t.passenger_name) + 1) AS Фамилия,
       contact_data:: json ->> 'phone'                                        AS Телефон
FROM tickets t
         LEFT JOIN ticket_flights tf ON t.ticket_no = tf.ticket_no
         LEFT JOIN flights f ON f.flight_id = tf.flight_id
WHERE (f.scheduled_departure BETWEEN '2017-08-01 00:00:00.000000 +00:00' AND '2017-08-01 12:00:00.000000 +00:00')
  AND (tf.fare_conditions = 'Business')
  AND (passenger_name LIKE '%OVA')
ORDER BY Фамилия;