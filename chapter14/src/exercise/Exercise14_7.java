package exercise;

import java.util.Random;
import java.util.stream.IntStream;

/* Exercise 14-7. 임의의 로또번호(1~45)를 정렬해서 출력하시오. */
class Exercise14_7 {
    public static void main(String[] args) {
        // 1부터 45까지의 임의의 정수 스트림 생성
        IntStream intStream = new Random().ints(1, 46);

        // 중복 제거 후 최대 6개의 번호를 선택하고 오름차순으로 정렬하여 출력
        intStream.distinct()     // 중복 제거
                .limit(6)       // 최대 6개의 번호 선택
                .sorted()       // 오름차순으로 정렬
                .forEach(System.out::println); // 출력
    }
}
