package example;

class DrawShape {
    public static void main(String[] args) {
        // 도형을 그리기 위한 Point 배열 생성
        Point[] p = {
                new Point(100, 100),
                new Point(140, 50),
                new Point(200, 100)
        };

        // Triangle 객체 생성
        Triangle t = new Triangle(p);

        // Circle 객체 생성
        Circle c = new Circle(new Point(150, 150), 50);

        // 삼각형과 원을 그립니다.
        t.draw();
        c.draw();
    }
}

// Shape 클래스
class Shape {
    String color = "black"; // 도형의 색상을 나타내는 멤버 변수

    // 도형을 그리는 메서드
    void draw() {
        System.out.printf("[color=%s]%n", color);
    }
}

// Point 클래스
class Point {
    int x;
    int y;

    // 좌표를 받아서 Point 객체를 생성하는 생성자
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 디폴트 생성자
    Point() {
        this(0, 0);
    }

    // x와 y 좌표를 문자열로 반환하는 메서드
    String getXY() {
        return "(" + x + "," + y + ")";
    }
}

// Circle 클래스 - Shape 클래스를 상속
class Circle extends Shape {
    Point center; // 원의 중심 좌표
    int r; // 반지름

    // 디폴트 생성자 - 중심 좌표 (0, 0), 반지름 100인 원 객체 생성
    Circle() {
        this(new Point(0, 0), 100);
    }

    // 중심 좌표와 반지름을 받아서 원 객체 생성하는 생성자
    Circle(Point center, int r) {
        this.center = center;
        this.r = r;
    }

    // 원을 그리는 메서드
    void draw() {
        System.out.printf("[center=(%d, %d), r=%d, color=%s]%n", center.x, center.y, r, color);
    }
}

// Triangle 클래스 - Shape 클래스를 상속
class Triangle extends Shape {
    Point[] p = new Point[3]; // 삼각형의 꼭지점 좌표를 담을 배열

    // Point 배열을 받아서 삼각형 객체 생성
    Triangle(Point[] p) {
        this.p = p;
    }

    // 삼각형을 그리는 메서드
    void draw() {
        System.out.printf("[p1=%s, p2=%s, p3=%s, color=%s]%n", p[0].getXY(), p[1].getXY(), p[2].getXY(), color);
    }
}

