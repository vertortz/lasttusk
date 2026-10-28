# Рекурсивные задачи на Java

Решения 40 задач на рекурсию собраны в классе `RecursionTasks`. Класс `Main`
содержит демонстрационный запуск всех задач с примерами входных данных.
Класс `RecursionTasksTest` проверяет решения без сторонних библиотек.

## Требования

- JDK 8 или новее

## Запуск

Откройте терминал в папке проекта и выполните:

```text
javac -encoding UTF-8 Main.java RecursionTasks.java
java Main
```

Чтобы запустить проверки:

```text
javac -encoding UTF-8 RecursionTasks.java RecursionTasksTest.java
java RecursionTasksTest
```

На Windows перед запуском можно переключить кодовую страницу консоли на UTF-8,
чтобы русские подписи отображались корректно:

```text
chcp 65001
java Main
```

## Структура проекта

- `RecursionTasks.java` — рекурсивные решения задач.
- `Main.java` — точка входа и примеры вызова всех 40 решений.
- `RecursionTasksTest.java` — автоматические проверки без сторонних библиотек.

Для использования решений в другом проекте можно вызывать статические методы
класса `RecursionTasks`.
