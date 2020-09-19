package Chapter3;

class Student {
    private String name;
    private int score;

    Student() {
        this.name = null;
        this.score = -1;
    }

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void setValue(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        if (this.name == null)
            System.out.println("ERROR: Variable Name is not initialized.");
        return this.name;
    }

    public int getScore() {
        if (this.score == -1)
            System.out.println("ERROR: Variable Score is not initialized.");
        return this.score;
    }

    public void getValue() {
        System.out.println("Name is " + getName() + " and score is " + getScore() + ".");
    }
}

// 斐波那契数列类
class FibonacciSequence {
    // 递归实现
    public int getNumberValue(int n) {
        if (n > 0) {    // 鲁棒性增强
            if (n == 1)
                return 0;
            else if (n == 2)
                return 1;
            else
                return getNumberValue(n - 1) + getNumberValue(n - 2);
        } else {
            System.out.println("ERROR: Number cannot be zero or negative.");
            return -1;
        }
    }
}

public class exercise1 {
    public static void main(String[] args) {
        Student stuA = new Student("Li Hua", 60);
        Student stuB = new Student();

        stuA.getValue();
        stuB.setValue("Xiao Ming", 80);
        stuB.getValue();

        System.out.println("N is 6 and value is " + new FibonacciSequence().getNumberValue(6));
    }
}
