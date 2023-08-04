package exercise;

import java.util.Arrays;
import java.util.Random;

class Exercise6_20 {
    // 배열의 값을 뒤섞은 후 결과 배열을 반환하는 메서드
    public static int[] shuffle(int[] arr) {
        int[] result = Arrays.copyOf(arr, arr.length);
        Random random = new Random();

        for (int i = result.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = result[i];
            result[i] = result[j];
            result[j] = temp;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(Arrays.toString(original));
        int[] result = shuffle(original);
        System.out.println(Arrays.toString(result));
    }
}

