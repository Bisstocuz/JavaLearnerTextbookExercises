package Chapter4;

class Student {
    // 姓名与年龄
    protected String name;
    protected int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void show() {
        System.out.println("Name is " + getName() + " and age is " + getAge() + ".");
    }
}

class Undergraduate extends Student {
    // 学位变量
    private String degree;

    Undergraduate(String name, int age, String degree) {
        super(name, age);
        this.degree = degree;
    }

    public void changeDegree(String degree) {
        this.degree = degree;
    }

    public String getDegree() {
        return this.degree;
    }

    public void show() {
        System.out.println("Name is " + super.getName() + " and age is " + super.getAge() + " with degree " + getDegree() + ".");
    }
}

public class exercise2 {
    public static void main(String[] args) {
        Student stu = new Student("Scot", 18);
        Undergraduate underStu = new Undergraduate("Carl", 19, "Computer Science and Technology");

        stu.show();
        underStu.show();
        underStu.changeDegree("Information Security");
        underStu.show();
    }
}
