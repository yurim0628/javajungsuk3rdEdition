package exercise;

public class Exercise6_23 {
    /**
     * 배열의 최대값을 반환한다.
     * 배열이 null이거나 길이가 0인 경우, -999999를 반환한다.
     *
     * @param arr 배열
     * @return 배열의 최대값 또는 -999999
     */
    static int max(int[] arr) {
        if (arr == null || arr.length == 0)
            return -999999;
        else {
            int maxValue = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > maxValue) {
                    maxValue = arr[i];
                }
            }
            return maxValue;
        }
    }

    public static void main(String[] args) {
        int[] data = { 3, 2, 9, 4, 7 };
        System.out.println(java.util.Arrays.toString(data));
        System.out.println("최대값: " + max(data));
        System.out.println("최대값: " + max(null));
        System.out.println("최대값: " + max(new int[] {})); // 크기가 0인 배열
    }
}
