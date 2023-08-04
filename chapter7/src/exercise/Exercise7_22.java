package exercise;

abstract class Shape {
    Point p; // 도형의 위치를 나타내는 Point 객체

    // 기본 생성자
    Shape() {
        this(new Point(0, 0));
    }

    // 매개변수가 있는 생성자
    Shape(Point p) {
        this.p = p;
    }

    // 도형의 면적을 계산해서 반환하는 추상 메서드
    abstract double calcArea();

    // 도형의 위치를 반환하는 메서드
    Point getPosition() {
        return p;
    }

    // 도형의 위치를 설정하는 메서드
    void setPosition(Point p) {
        this.p = p;
    }
}

class Point {
    int x; // x 좌표
    int y; // y 좌표

    // 기본 생성자
    Point() {
        this(0, 0);
    }

    // 매개변수가 있는 생성자
    Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 위치를 문자열로 표현하는 메서드
    public String toString() {
        return "[" + x + "," + y + "]";
    }
}

class Circle extends Shape {
    double r; // 원의 반지름

    // 기본 생성자
    Circle(double r) {
        this(new Point(0, 0), r);
    }

    // 매개변수가 있는 생성자
    Circle(Point p, double r) {
        super(p);
        this.r = r;
    }

    // 원의 면적 계산
    double calcArea() {
        return Math.PI * Math.pow(r, 2);
    }
}

class Rectangle extends Shape {
    double width; // 사각형의 폭
    double height; // 사각형의 높이

    // 기본 생성자
    Rectangle(double width, double height) {
        this(new Point(0, 0), width, height);
    }

    // 매개변수가 있는 생성자
    Rectangle(Point p, double width, double height) {
        super(p);
        this.width = width;
        this.height = height;
    }

    // 사각형의 면적 계산
    double calcArea() {
        return width * height;
    }

    // 정사각형인지 여부를 반환하는 메서드
    boolean isSquare() {
        return width * height != 0 && width == height;
    }
}

class Exercise7_22 {
    public static void main(String args[]) { }
}
