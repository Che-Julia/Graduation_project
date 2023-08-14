# Инструкция по запуску

### Необходимое ПО:
docker, jre(не ниже 11 версии), gradle, git

### 1.Склонировать репозиторий
git clone https://github.com/Che-Julia/Graduation_project

### 2. Запустить базу данных (в докере):
Для работы с базой данных mysql выполнить команду:  
docker-compose -f docker-compose-mysql.yml up -d После прогона тестов остановить контейнеры:  
docker-compose -f docker-compose-mysql.yml down

Для работы с базой данных postgres выполнить команду:  
docker-compose -f docker-compose-postgres.yml up -d После прогона тестов остановить контейнеры:  
docker-compose -f docker-compose-postgres.yml down

### 3. Запустить бэк приложения:

Для запуска приложения с базой данных mysql или postgresql в файле application.properties раскомментировать нужный
spring.datasource.url  
Выполнить команду java -jar aqa-shop.jar

### 4. Запустить фронт приложения:
cd ./gate-simulator  
npm start  

### 5. Запустить тесты:
gradlew test

### 6. Открыть отчеты в браузере командой:
gradlew allureServe
