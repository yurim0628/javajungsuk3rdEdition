package example;

class PointTest2 {
    public static void main(String args[]) {
        Point3D2 p3 = new Point3D2();
        System.out.println("p3.x=" + p3.x);
        System.out.println("p3.y=" + p3.y);
        System.out.println("p3.z=" + p3.z);
    }
}

class Point3 {
    int x = 10; // 멤버 변수 x의 기본값은 10
    int y = 20; // 멤버 변수 y의 기본값은 20

    Point3(int x, int y) { // 매개변수를 받는 생성자
        this.x = x;
        this.y = y;
    }
}

class Point3D2 extends Point3 {
    int z = 30; // 멤버 변수 z의 기본값은 30

    Point3D2() {
        this(100, 200, 300); // Point3D2(int x, int y, int z) 생성자 호출
    }

    Point3D2(int x, int y, int z) {
        super(x, y); // Point3(int x, int y) 생성자 호출
        this.z = z;
    }
}

