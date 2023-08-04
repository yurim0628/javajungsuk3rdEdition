package example;

class PointTest {
    public static void main(String args[]) {
        Point3D p3 = new Point3D(1, 2, 3);
        System.out.println(p3.getLocation()); // x: 1, y: 2, z: 3 출력
    }
}

class Point2 {
    int x;
    int y;

    Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    String getLocation() {
        return "x: " + x + ", y: " + y;
    }
}

class Point3D extends Point2 {
    int z;

    Point3D(int x, int y, int z) {
        super(x, y); // 부모 클래스(Point2)의 생성자를 호출하여 x와 y를 초기화
        this.z = z;
    }

    @Override
    String getLocation() {
        return super.getLocation() + ", z: " + z;
    }
}

