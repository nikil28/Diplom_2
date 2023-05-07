### **Diplom_2**

# Задание 2: API
Тебе нужно протестировать ручки API для [Stellar Burgers](https://stellarburgers.nomoreparties.site/).
Пригодится [документация API](https://code.s3.yandex.net/qa-automation-engineer/java/cheatsheets/paid-track/diplom/api-documentation.pdf). В ней описаны все ручки сервиса. Тестировать нужно только те, которые указаны в задании. Всё остальное — просто для контекста.

## **Создание пользователя:**

* создать уникального пользователя;
* создать пользователя, который уже зарегистрирован;
* создать пользователя и не заполнить одно из обязательных полей.

## **Логин пользователя:**

* логин под существующим пользователем,
* логин с неверным логином и паролем.

## **Изменение данных пользователя:**

* с авторизацией,
* без авторизации,
Для обеих ситуаций нужно проверить, что любое поле можно изменить. Для неавторизованного пользователя — ещё и то, что система вернёт ошибку.

## **Создание заказа:**

* с авторизацией,
* без авторизации,
* с ингредиентами,
* без ингредиентов,
* с неверным хешем ингредиентов.

## **Получение заказов конкретного пользователя:**

* авторизованный пользователь,
* неавторизованный пользователь.

## **Что нужно сделать**

* Создай отдельный репозиторий для тестов API.
* Создай `Maven`-проект.
* Подключи `JUnit 4`, `RestAssured` и `Allure`.
* Напиши тесты.
* Сделай отчёт в `Allure`.#   D i p l o m _ 2  
 