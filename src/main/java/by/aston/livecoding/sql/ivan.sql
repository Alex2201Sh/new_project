create table customers(id uuid primary key, name varchar(100) not null unique);
create table orders(id uuid primary key, title varchar(500) not null, price decimal not null, customer_id references customers(id));

-- получить таблицу (customer_name, prices_sum)
-- где показана сумма заказов для каждого покупателя
-- Условия:
-- 1) цена любого отдельного заказа, учитываемого в выборке, строго меньше, чем 100_000 (т.е. заказ с ценой 92_000_000 -> не учитывается)
-- 2) общая сумма заказов одного пользователя в выборке строго больше, чем 1_000 (т.е. если общая сумма заказов покупателя - 821 -> покупателя нет в выборке)

--для тех же таблиц получить всех пользователей, у которых есть хоть один заказ с "title = 'Чашка'"

--для тех же таблиц получить всех пользователей, у которых есть хоть один заказ с "title = 'Чашка'" и все (!) их заказы (типа c.*, o.*);

