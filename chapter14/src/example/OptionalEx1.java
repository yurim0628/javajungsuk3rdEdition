package example;

import java.util.*;

class OptionalEx1 {
	public static void main(String[] args) {
		// 문자열 "abcde"로 Optional 객체 생성
		Optional<String> optStr = Optional.of("abcde");

		// 문자열의 길이를 매핑하여 Optional 객체 생성
		Optional<Integer> optInt = optStr.map(String::length);

		System.out.println("optStr = " + optStr.get());
		System.out.println("optInt = " + optInt.get());

		// "123" 문자열로부터 정수로 매핑한 결과 (길이가 0보다 큼)
		int result1 = Optional.of("123")
				.filter(x -> x.length() > 0)
				.map(Integer::parseInt).get();

		// 빈 문자열로부터 정수로 매핑한 결과 (길이가 0보다 작음)
		int result2 = Optional.of("")
				.filter(x -> x.length() > 0)
				.map(Integer::parseInt).orElse(-1);

		System.out.println("result1 = " + result1);
		System.out.println("result2 = " + result2);

		// "456" 문자열로부터 정수로 매핑한 결과 출력
		Optional.of("456").map(Integer::parseInt)
				.ifPresent(x -> System.out.printf("result3 = %d%n", x));

		// 정수값을 가지는 OptionalInt 객체 생성
		OptionalInt optInt1 = OptionalInt.of(0);    // 0 저장

		// 빈 OptionalInt 객체 생성
		OptionalInt optInt2 = OptionalInt.empty();

		System.out.println(optInt1.isPresent());    // true
		System.out.println(optInt2.isPresent());    // false

		System.out.println(optInt1.getAsInt());     // 0
//        System.out.println(optInt2.getAsInt());     // NoSuchElementException
		System.out.println("optInt1 = " + optInt1);
		System.out.println("optInt2 = " + optInt2);
		System.out.println("optInt1.equals(optInt2) ? " + optInt1.equals(optInt2));

		// null 값을 저장하는 Optional 객체 생성
		Optional<String> opt = Optional.ofNullable(null);

		// 빈 Optional 객체 생성
		Optional<String> opt2 = Optional.empty();

		System.out.println("opt = " + opt);
		System.out.println("opt2 = " + opt2);
		System.out.println("opt.equals(opt2) ? " + opt.equals(opt2));    // true

		// 문자열을 정수로 변환하여 반환 (변환 중 예외 발생 시 기본값 반환)
		int result3 = optStrToInt(Optional.of("123"), 0);
		int result4 = optStrToInt(Optional.of(""), 0);

		System.out.println("result3 = " + result3);
		System.out.println("result4 = " + result4);
	}

	// Optional<String>을 정수로 변환하는 메서드
	static int optStrToInt(Optional<String> optStr, int defaultValue) {
		try {
			return optStr.map(Integer::parseInt).get();
		} catch (Exception e) {
			return defaultValue;
		}
	}
}
