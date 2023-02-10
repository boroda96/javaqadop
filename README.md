# Задание 1. Дописываем тесты (обязательное к выполнению)
Нашей целью будет переделать проект с приложением про бонус с покупки на Мавен и хорошо его протестировать.

Шаг 1. Создайте проект на базе Maven.

Шаг 2. Добавьте в проект JUnit Jupiter & Surefire Plugin

Шаг 3. Создайте сервисный класс со следующим исходным кодом:

```java
 public class BonusService {
  public long calculate(long amount, boolean registered) {
    int percent = registered ? 3 : 1;
    long bonus = amount * percent / 100;
    long limit = 500;
    if (bonus > limit) {
      bonus = limit;
    }
    return bonus;
  }
}
```
Шаг 4. Создайте тестовый класс со следующим исходным кодом:

```java
import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

  @org.junit.jupiter.api.Test
  void shouldCalculateForRegisteredAndUnderLimit() {
    BonusService service = new BonusService();

    // подготавливаем данные:
    long amount = 1000;
    boolean registered = true;
    long expected = 30;

    // вызываем целевой метод:
    long actual = service.calculate(amount, registered);

    // производим проверку (сравниваем ожидаемый и фактический):
    assertEquals(expected, actual);
  }

  @org.junit.jupiter.api.Test
  void shouldCalculateForRegisteredAndOverLimit() {
    BonusService service = new BonusService();

    // подготавливаем данные:
    long amount = 1_000_000;
    boolean registered = true;
    long expected = 500;

    // вызываем целевой метод:
    long actual = service.calculate(amount, registered);

    // производим проверку (сравниваем ожидаемый и фактический):
    assertEquals(expected, actual);
  }
}
```
Шаг 5. Запустите тесты через mvn clean test, убедитесь, что они запускаются и проходят.

Шаг 6. Проведите тест-дизайн сервисного класса, очень глубоко его можно не проводить, допишите недостающие тесты.

Шаг 7. Убедитесь, что тесты запускаются и проходят.

Итого: отправьте на проверку ссылку на репозиторий GitHub с вашим проектом.