package exercise;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* Exercise 14-6. 문자열 배열 strArr의 문자열 중에서 가장 긴 것의 길이를 출력하시오. */
class Exercise14_6 {
    public static void main(String[] args) {
        // 주어진 문자열 배열
        String[] strArr = { "aaa", "bb", "c", "dddd" };

        // 문자열 배열로부터 스트림 생성
        Stream<String> strStream1 = Stream.of(strArr);
        Stream<String> strStream2 = Stream.of(strArr);

        // 가장 긴 문자열을 찾아 해당 문자열의 길이를 가져옴
        String stringMax = strStream1.collect(
                Collectors.collectingAndThen(
                        Collectors.maxBy(
                                Comparator.comparingInt(String::length)
                        ), Optional::get
                )
        );

        // 가장 긴 문자열의 길이를 구함
        int lengthMax = strStream2.collect(
                Collectors.collectingAndThen(
                        Collectors.collectingAndThen(
                                Collectors.maxBy(
                                        Comparator.comparingInt(String::length)
                                ), Optional::get
                        ), String::length
                )
        );

        // 결과 출력
        System.out.printf("%s : %d", stringMax, lengthMax);
        System.out.println();

        // 스트림을 이용하여 가장 긴 문자열 길이를 출력 (방법 1)
        Stream<String> strStream3 = Stream.of(strArr);

        strStream3.map(String::length)
                .sorted(Comparator.reverseOrder())
                .limit(1).forEach(System.out::println);

        // 스트림을 이용하여 가장 긴 문자열 길이를 출력 (방법 2)
        Stream<String> strStream4 = Stream.of(strArr);

        strStream4.sorted(Comparator.comparingInt(String::length).reversed())
                .limit(1).forEach(System.out::println);
    }
}
