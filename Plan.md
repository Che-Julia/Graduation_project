1. Планирование автоматизации тестирования

UI тесты
1. Позитивные тесты
   Покупка картой 4444 4444 4444 4441 (валидные значения)
   Покупка в кредит картой 4444 4444 4444 4441 (валидные значения)
   Покупка картой 4444 4444 4444 4442 (валидные значения)
   Покупка в кредит картой 4444 4444 4444 4442 (валидные значения)

2. Негативные тесты
   Покупка картой 4444 4444 4444 4441 (невалидные значения)
   Покупка в кредит картой 4444 4444 4444 4441 (невалидные значения)
   Покупка картой 4444 4444 4444 4442 (невалидные значения)
   Покупка в кредит картой 4444 4444 4444 4442 (невалидные значения)

API тесты
1. Поддержка MySQL
2. Поддержка PostgreSQL

2. Перечень используемых инструментов

Rest Assured - для написания API тестов ввиду стабильноти и актуальности
Docker - для изолированного запуска приложений
GitHub - система контроля версий
Selenide - для написания UI автотестов, ввиду упрощения написания автотестов: много реализованных методов
JUnit - фреймворк АТ, ввиду наличия необходимого функционала: запуска, параллелизации и проверок
Allure - удобная система отчетности
Gradle - сборщик, обладает необходимым набором функций подключения зависимостей, компиляции и запуску АТ,
а также удобным файлом настроек (build gradle) на Groovy

3. Перечень и описание возможных рисков при автоматизации

Риски связанные с:
- Настройкой подключения к БД
- Запуском приложения (jar, npm)
- Версиями библиотек (они должны работать друг с другом, к примеру Allure и Selenide)
- Написанием тест-кейсов: нужно тщательно описать проверки

4. Интервальная оценка с учётом рисков в часах

Подготовка окружения, развертывание БД - 10 часов.
Написание автотестов, тестирование и отладка автотестов - 36 часов.
Формирование отчетов - 5 часов.

5. План сдачи работ: когда будут готовы автотесты, результаты их прогона

Настройка окружения, написание и отладка автотестов, тестирование - 08.07.2023
Подготовка отчетных документов - 10.07.2023