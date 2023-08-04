package example;

import java.util.function.*;

class LambdaEx7 {
	public static void main(String[] args) {
		// String을 16진수로 변환하는 람다식
		Function<String, Integer> f1 = (s) -> Integer.parseInt(s, 16);

		// Integer를 이진수로 변환하는 람다식
		Function<Integer, String> g1 = (i) -> Integer.toBinaryString(i);

		// f1 람다식 다음에 g1 람다식을 실행하는 새로운 람다식
		Function<String, String> h1 = f1.andThen(g1);

		// g1 람다식 다음에 f1 람다식을 실행하는 새로운 람다식
		Function<Integer, Integer> h2 = f1.compose(g1);

		System.out.println(h1.apply("FF"));  // "FF" -> 255 -> "11111111"
		System.out.println(h2.apply(2));     // 2 -> "10" -> 16

		// 항등 함수 (identity function) - 입력값을 그대로 반환하는 람다식
		Function<String, String> f2 = x -> x;
		System.out.println(f2.apply("AAA"));  // "AAA" 그대로 출력

		// 정수를 받아서 100보다 작은지 검사하는 람다식
		Predicate<Integer> p1 = i -> i < 100;

		// 정수를 받아서 200보다 작은지 검사하는 람다식
		Predicate<Integer> q1 = i -> i < 200;

		// 정수를 받아서 짝수인지 검사하는 람다식
		Predicate<Integer> r1 = i -> i % 2 == 0;

		// p1 람다식의 부정 (negate)
		Predicate<Integer> notP1 = p1.negate();  // i >= 100

		// notP1 람다식과 q1 람다식 또는 r1 람다식을 결합한 새로운 람다식
		Predicate<Integer> all = notP1.and(q1.or(r1));
		System.out.println(all.test(150));  // true

		String str1 = "abc";
		String str2 = "abc";

		// str1과 str2가 같은지 비교하는 Predicate
		Predicate<String> p2 = Predicate.isEqual(str1);

		boolean result = p2.test(str2);
		System.out.println(result);
	}
}
