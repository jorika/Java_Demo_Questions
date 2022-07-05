import java.util.Objects;

public class Person {
    private final int age;
    private final String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + name + " has " + age + " years old";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // если ссылки совпадают, то объекты равны
        if (o == null || getClass() != o.getClass()) return false; // если объект равен null или классы сравниваемых объектов не совпадают, то они точно не равны
        Person person = (Person) o; // приводим объект к нужному классу
        // сравниваем примитивный тип с помощью оператора ==, а ссылочный String с помощью встроенного метода объекта Objects
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        // используем утилитный класс Objects для расчета хеша объекта
        return Objects.hash(age, name);
    }
}
