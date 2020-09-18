package Chapter4;

// 抽象类 Shape
interface Shape {
    double area(double value);

    double volume(double value);
}

class Square implements Shape {
    // 求正方形面积
    public double area(double value) {
        return value * value;
    }

    // 求正方形体积
    public double volume(double value) {
        return value * value * value;
    }
}

class Circle implements Shape {
    // 求圆形面积
    public double area(double value) {
        return Math.PI * value * value;
    }

    // 求球体体积
    public double volume(double value) {
        return 4.0 / 3.0 * area(value);
    }
}

public class exercise3 {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println("边长为2的正方形面积为 " + square.area(2) + "，体积为 " + square.volume(2));

        Circle circle = new Circle();
        System.out.println("半径为3的圆形面积为 " + circle.area(3) + "，体积为 " + circle.volume(3));
    }
}
