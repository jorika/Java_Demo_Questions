public class App {

    public static void main(String[] args) {
        // test 1: employee is not equals person
        // объекты разных классов не равны
        Person person = new Person("Jack", 18);
        Employee employee = new Employee("Jack", 18, "writer");
        System.out.println(person.equals(employee));
        System.out.println(person.hashCode() == employee.hashCode());
        // test 2: employee equals
        // два объекта с одинаковыми значениями полей равны
        Employee employee1 = new Employee("Bob", 24, "designer");
        Employee employee2 = new Employee("Bob", 24, "designer");
        System.out.println(employee1.equals(employee2));
        System.out.println(employee1.hashCode() == employee2.hashCode());
        // test 3: employee name
        // объекты отличаются именем - не равны
        Employee employee3 = new Employee("Bob", 24, "designer");
        Employee employee4 = new Employee("Kate", 24, "designer");
        System.out.println(employee3.equals(employee4));
        System.out.println(employee3.hashCode() == employee4.hashCode());
        // test 4: employee age
        // объекты отличаются значениями переменной age - не равны
        Employee employee5 = new Employee("Kate", 28, "designer");
        Employee employee6 = new Employee("Kate", 24, "designer");
        System.out.println(employee5.equals(employee6));
        System.out.println(employee5.hashCode() == employee6.hashCode());
        // test 5: employee role
        // объекты отличаются значениями переменной role - не равны
        Employee employee7 = new Employee("Kate", 24, "hr");
        Employee employee8 = new Employee("Kate", 24, "designer");
        System.out.println(employee7.equals(employee8));
        System.out.println(employee7.hashCode() == employee8.hashCode());
        // test 6: person equals
        // два объекта с одинаковыми полями равны
        Person person1 = new Person("Bob", 25);
        Person person2 = new Person("Bob", 25);
        System.out.println(person1.equals(person2));
        System.out.println(person1.hashCode() == person2.hashCode());
        // test 7: person name
        // объекты с разными значениями поля name - не равны
        Person person3 = new Person("Bob", 25);
        Person person4 = new Person("Kate", 25);
        System.out.println(person3.equals(person4));
        System.out.println(person3.hashCode() == person4.hashCode());
        // test 8: person age
        // объекты отличаются значениями переменной age - не равны
        Person person5 = new Person("Kate", 28);
        Person person6 = new Person("Kate", 25);
        System.out.println(person5.equals(person6));
        System.out.println(person5.hashCode() == person6.hashCode());
        // advanced
        // test 9: employee with null-field name
        // объекты с значением имени null - равны
        Employee employee9 = new Employee(null, 0,"hr");
        Employee employee10 = new Employee(null, 0,"hr");
        System.out.println(employee9.equals(employee10));
        System.out.println(employee9.hashCode() == employee10.hashCode());
        // test 10: employee with null-field role
        // объекты с значением роли null - равны
        Employee employee11 = new Employee("John", 0,null);
        Employee employee12 = new Employee("John", 0,null);
        System.out.println(employee11.equals(employee12));
        System.out.println(employee11.hashCode() == employee12.hashCode());
        // test 11: employee with two null-field
        // объекты с значением имени и роли null - равны
        Employee employee13 = new Employee(null, 0,null);
        Employee employee14 = new Employee(null, 0,null);
        System.out.println(employee13.equals(employee14));
        System.out.println(employee13.hashCode() == employee14.hashCode());
    }


}
