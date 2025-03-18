category
    id    name
    1     сладкое
    2     соленое
    3     фрукты

    product
    id    category_id    price    name
    1     1              50       печенье
    2     1              75       мармелад
    3     1              100      конфеты
    4     1              125      шоколад
    5     2              150      арахис
    6     2              75       чипсы
    7     2              150      кальмары
    8     3              175      лимон
    9     3              200      гранат

    выбрать все продукты в которых категория такая же как и у конфет и цена меньше 100


    select * from product where category_id = (select category_id from product where name = 'конфеты' and price < 100 limit 1);