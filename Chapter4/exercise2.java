package Chapter4;

class Student {
    // 姓名与年龄
    protected String name;
    protected int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println("Name is " + this.name + " and age is " + this.age + ".");
    }
}

class Undergraduate extends Student {
    // 学位变量
    private String degree;

    Undergraduate(String name, int age, String degree) {
        super(name, age);
        this.degree = degree;
    }

    public void show() {
        System.out.println("Name is " + super.name + " and age is " + super.age + " with degree " + this.degree + ".");
    }
}

public class exercise2 {
    public static void main(String[] args) {
        Student stu = new Student("Scot", 18);
        Undergraduate underStu = new Undergraduate("Carl", 19, "Information Security");

        stu.show();
        underStu.show();
    }
}
