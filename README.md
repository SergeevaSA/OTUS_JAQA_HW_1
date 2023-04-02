### OTUS_JAQA_HW_1
Данный проект представляет собой простое консольное приложение для демонстрации использования Selenium WebDriver для автоматизации тестирования веб-страниц OTUS (UI, E2E).

#### Задание: 
1. Реализовать фабрику (WebDriverFactory), которая будет получать значение из окружения и запускать соответствующий браузер: Chrome, Firefox, Opera.
2. Реализовать подсветку элементов перед нажатием, после нажатия вернуть данные в исходное состояние.
3. На главной странице "OTUS" снизу найти список курсов (популярные курсы, специализации, рекомендации) и реализовать: 
- Метод фильтр по названию курса;
- Метод выбора курса, стартующего раньше всех/позже всех (при совпадении дат - выбрать любой) при помощи reduce.
4. Реализовать движение мыши при помощи и выбор курса при помощи библиотеки Actions.

#### Объект:
Онлайн-платформа для обучения IT-специалистов "OTUS" (https://otus.ru):
- Frontend: HTML, CSS и JavaScript (React, Redux, Redux-Saga и др.).
- Backend: Java с использованием фреймворка Spring. 
- API: RESTful API.

#### Стек технологий:
- Java 11;
- Selenium WebDriver (3.141.59);
- Maven 5.8.1;
- JUnit 5;
- Git;
- IntelliJ IDEA.

#### Структура проекта:
- pom.xml - файл, содержащий информацию о проекте и его зависимостях;
- src/main/java - директория, содержащая исходный код приложения;
- src/test/java - исходный код тестов;
- src/main/resources - директория, содержащая файлы с настройками браузера;
- .gitignore - файл, указывающий Git, какие файлы и директории следует игнорировать при commit;
- README.md - файл с описанием проекта и инструкцией по запуску.

#### Запуск проекта:
1. Склонировать репозиторий проекта с помощью команды git clone https://github.com/SergeevaSA/OTUS_JAQA_HW_1.git;
2. Открыть проект в IntelliJ IDEA (или иной среде разработки);
3. Запустить тесты с помощью команды mvn clean test в терминале. Можно дополнительно использовать команды для запуска в отдельных браузерах:
- Chrome: mvn clean test -D chrome
- Firefox: mvn clean test -D firefox
- Opera: mvn clean test -D opera

#### Примечание: 
При проектировании тестов были соблюдены принципы программирования SOLID, KISS, DRY и YAGNI, а также были использованы следующие паттерны:
- Page Object Pattern - используется для создания объектной модели веб-страниц;
- Singleton Pattern - использован для создания экземпляра драйвера Selenium WebDriver, который может быть использован в различных тестах.
- Factory Pattern - используется для создания экземпляров страниц с помощью фабричного метода.
- Dependency Injection Pattern - используется для инъекции драйвера Selenium WebDriver в объекты страниц, используя конструктор.
- Builder Pattern - используется для создания объектов с помощью шагов-методов, где каждый шаг добавляет новые свойства в объект. 
- Chain of Responsibility Pattern - используется для создания цепочки обработчиков исключений при работе в проекте.