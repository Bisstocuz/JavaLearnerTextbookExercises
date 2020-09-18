package Chapter3and4;

class Student {
    private String name;
    private int score;

    Student() {

    }

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void setValue(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void getValue() {
        System.out.println("name is " + this.name + " and score is " + this.score + ".");
    }

}

class FibonacciSequence {
    public int getNumberValue(int n) {
        if (n == 1)
            return 0;
        else if (n == 2)
            return 1;
        else
            return getNumberValue(n - 1) + getNumberValue(n - 2);
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
