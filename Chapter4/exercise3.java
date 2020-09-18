package Chapter4;

// 抽象类 Shape
interface Shape {
    double area(double value);
}

class Square implements Shape {
    // 求正方形面积
    public double area(double value) {
        return value * value;
    }
}

class Circle implements Shape {
    // 求圆形面积
    public double area(double value) {
        return Math.PI * value * value;
    }
}

public class exercise3 {
    public static void main(String[] args) {
        System.out.println("边长为2的正方形面积为 " + new Square().area(2));
        System.out.println("半径为3的圆形面积为 " + new Circle().area(3));
    }
}
