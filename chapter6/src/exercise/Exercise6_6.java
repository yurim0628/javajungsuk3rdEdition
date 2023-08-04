package exercise;

class Exercise6_6 {
    /**
     * 두 점 (x, y)와 (x1, y1) 간의 거리를 구한다.
     *
     * @param x  첫 번째 점의 x 좌표
     * @param y  첫 번째 점의 y 좌표
     * @param x1 두 번째 점의 x 좌표
     * @param y1 두 번째 점의 y 좌표
     * @return 두 점 사이의 거리
     */
    static double getDistance(int x, int y, int x1, int y1) {
        double distance = Math.abs(x - x1) + Math.abs(y - y1);
        return Math.sqrt(distance);
    }

    public static void main(String args[]) {
        System.out.println(getDistance(1, 1, 2, 2));
    }
}
