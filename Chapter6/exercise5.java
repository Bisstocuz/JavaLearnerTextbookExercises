package Chapter6;

import java.util.HashSet;

class Person {
    private final String name;
    private final int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 重写 toString
    public String toString() {
        return this.name + ": " + this.age;
    }

    // 重写 hashCode
    public int hashCode() {
        return this.name.hashCode();
    }

    // 重写 equals
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;
        Person person = (Person) obj;
        return this.name.equals(person.name);
    }
}

public class exercise5 {
    public static void main(String[] args) {
        HashSet<Person> set = new HashSet<>();
        set.add(new Person("Kevin", 19));
        set.add(new Person("Carl", 20));
        set.add(new Person("Kevin", 24));

        set.forEach(System.out::println);   // 输出结果
    }
}
