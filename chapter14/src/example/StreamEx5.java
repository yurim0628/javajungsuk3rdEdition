package example;

import java.util.*;
import java.util.stream.*;

class StreamEx5 {
	public static void main(String[] args) {
		String[] strArr = {
				"Inheritance", "Java", "Lambda", "Stream",
				"OptionalDouble", "IntStream", "count", "sum"
		};

		// 문자열 배열 출력
		Stream.of(strArr).forEach(System.out::println);

		// 모든 문자열이 비어있지 않은지 확인
		boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0);

		// 's'로 시작하는 첫 번째 문자열 검색
		Optional<String> sWord = Stream.of(strArr)
				.filter(s -> s.charAt(0) == 's')
				.findFirst();

		System.out.println("noEmptyStr = " + noEmptyStr);
		System.out.println("sWord = " + sWord.get());

		// Stream<String[]>을 IntStream으로 변환
		IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

		// 각종 통계 정보 계산 및 출력
		int count = intStream1.reduce(0, (a, b) -> a + 1);
		int sum = intStream2.reduce(0, (a, b) -> a + b);

		OptionalInt max = intStream3.reduce(Integer::max);
		OptionalInt min = intStream4.reduce(Integer::min);

		System.out.println("count = " + count);
		System.out.println("sum = " + sum);
		System.out.println("max = " + max.getAsInt());
		System.out.println("min = " + min.getAsInt());
	}
}