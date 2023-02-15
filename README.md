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

# Задание 2*. @CsvFileSource (необязательная задача повышенной сложности)
Мы с вами на лекции разобрали аннотацию `@CsvSource`, внутри которой можно писать строки в формате CSV.

Писать значения прямо в аннотации не плохо, но если их будет штук 50, то, наверное, ничего хорошего из этого не выйдет.

Поэтому хорошо бы воспользоваться возможностями JUnit и аннотации `@CsvFileSource`.

Вам необходимо взять проект с калькулятором бонусов и переписать сценарии таким образом, чтобы данные читались из файла формата CSV.

Сам файл необходимо положить в каталог `resources`, который тоже нужно создать, следующим образом:

![](https://user-images.githubusercontent.com/53707586/149668473-da63281c-4243-4071-a6cf-89e45036b9d1.png)

Быстро это сделать можно вот так: `Alt + Insert` на каталоге test выбираете `New File` и дальше вводите имя файла вместе с именем каталога:

![](https://user-images.githubusercontent.com/53707586/149668489-54c14f68-9c83-4290-b700-5d2b5def114f.png)

IDEA сама за вас создаст и каталог, и файл.

После чего в боковой панельке следует сделать reimport Maven-проекта:

![](https://user-images.githubusercontent.com/53707586/149668495-8ceb5cd7-eee0-41d5-96ac-e2b555f9d206.png)

И IDEA поставит вам красивую иконочку на ресурсы для тестов:

![](https://user-images.githubusercontent.com/53707586/149668513-62555f95-f0f2-440f-927c-4feb0e337f42.png)

Сам файл вы можете редактировать прямо в IDEA, это обычный текстовый файл, но подчиняющийся правилам CSV.

При этом обратите внимание, что кодировка файла UTF8:

![](https://user-images.githubusercontent.com/53707586/149668544-fd8fc7a2-dd46-4811-800e-51094f0d04d8.png)

Если это не так, кликните на указанном поле и выберите UTF8:

![](https://user-images.githubusercontent.com/53707586/149668575-749f377d-ec5b-4a06-a3ae-51a19dacd0bc.png)

Например, на лекции было (`value` требовал массив):

```java
@CsvSource(
value={
"'registered user, bonus under limit',100060,true,30",
"'registered user, bonus over limit',100000060,true,500"
}
)
```
Если элемент в массиве только один, то полная запись:
```java
@CsvSource(
value={
"'registered user, bonus under limit',100060,true,30"
}
) 
```
Сокращённая — работает только с одним элементом:
```java
@CsvSource(value="'registered user, bonus under limit',100060,true,30")
```
А если вы везунчик, и элемент ещё и называется `value`, то:
```java
@CsvSource("'registered user, bonus under limit',100060,true,30")
```
Использованная аннотация должна выглядеть следующим образом:
```java
@CsvFileSource(resources = "/data.csv")
```
### Решение
При отправке решения в личном кабинете прикрепите ссылку на ваш публичный репозиторий GitHub с вашим проектом.