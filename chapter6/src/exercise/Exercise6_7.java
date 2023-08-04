package exercise;

class MyPoint {
    int x;
    int y;

    /**
     * MyPoint 객체를 생성하고 x, y 좌표를 초기화한다.
     *
     * @param x x 좌표
     * @param y y 좌표
     */
    MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 현재 좌표와 주어진 점 (x1, y1) 간의 거리를 계산한다.
     *
     * @param x1 다른 점의 x 좌표
     * @param y1 다른 점의 y 좌표
     * @return 현재 좌표와 주어진 점과의 거리
     */
    double getDistance(int x1, int y1) {
        double distance = Math.abs(x - x1) + Math.abs(y - y1);
        return Math.sqrt(distance);
    }
}

class Exercise6_7 {
    public static void main(String args[]) {
        // MyPoint 객체 생성 및 초기화
        MyPoint p = new MyPoint(1, 1);

        // 다른 점과의 거리 계산 및 출력
        System.out.println(p.getDistance(2, 2));
    }
}