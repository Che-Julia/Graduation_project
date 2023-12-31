# Отчёт по итогам тестирования


## Краткое описание


Была проведена работа по автоматизации тестирования приложения для оплаты тура согласно [плана автоматизации](https://github.com/Che-Julia/Graduation_project/blob/main/Plan.md).

Были написаны:

Позитивные и негативные UI тесты

Тесты для проверки записей в БД


## Количество тест-кейсов
Всего: 8 тестов

Успешных: 6 (75%)

Неуспешных: 2 (25%)


## Общие рекомендации

### Найденные баги
[Ошибка в названии города (Марракеш)](https://github.com/Che-Julia/Graduation_project/issues/1)\
[При выборе способа оплаты не происходит выделение кнопок (Купить/Купить в кредит)](https://github.com/Che-Julia/Graduation_project/issues/2)\
[При вводе данных неактивной (DECLINE) карты проходит операция покупки](https://github.com/Che-Julia/Graduation_project/issues/3)\
[При совершении операции покупки в кредит активной (APPROVED) и неактивной (DECLINE) картой не создается запись в поле credit_id таблицы order_entity](https://github.com/Che-Julia/Graduation_project/issues/4)\
[При вводе некорректных данных в поле "Месяц" проходит оплата](https://github.com/Che-Julia/Graduation_project/issues/6)\
[Отсутствует валидация поля "Владелец"](https://github.com/Che-Julia/Graduation_project/issues/5)\
[При оплате с незаполненным полем CVC/CVV появляется ошибка под заполненным полем "Владелец"](https://github.com/Che-Julia/Graduation_project/issues/7)\
[При вводе некорректных данных в поле "Имя" проходит оплата](https://github.com/Che-Julia/Graduation_project/issues/8)


## Рекомендации
Исправить найденные баги

Сделать валидацию полей