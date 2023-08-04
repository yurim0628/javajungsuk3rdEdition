package exercise;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/* Exercise 14-5. 문자열 배열 strArr의 모든 문자열의 길이를 더한 결과를 출력하시오. */
class Exercise14_5 {
    public static void main(String[] args) {
        // 주어진 문자열 배열
        String[] strArr = { "aaa", "bb", "c", "dddd" };

        // 문자열 배열로부터 스트림 생성
        Stream<String> strStream = Stream.of(strArr);

        // 문자열 길이의 합을 계산하여 출력
        int sum = strStream.collect(Collectors.summingInt(String::length));
        System.out.printf("sum = %d", sum);
        System.out.println();

        // 문자열 배열로부터 스트림 생성
        Stream<String> strStream2 = Stream.of(strArr);

        // mapToInt()을 이용하여 문자열 길이를 정수 스트림으로 변환하고 합을 구하여 출력
        sum = strStream2.mapToInt(String::length).sum();
        System.out.println("sum = " + sum);
    }
}
