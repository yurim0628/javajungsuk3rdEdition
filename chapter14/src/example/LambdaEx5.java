package example;

import java.util.function.*;
import java.util.*;

class LambdaEx5 {
	public static void main(String[] args) {
		// Supplier 함수형 인터페이스로 랜덤한 정수 생성
		Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1;

		// Consumer 함수형 인터페이스로 정수 출력
		Consumer<Integer> c = i -> System.out.print(i + ", ");

		// Predicate 함수형 인터페이스로 짝수 판별
		Predicate<Integer> p = i -> i % 2 == 0;

		// Function 함수형 인터페이스로 일의 자리를 제거하는 함수 생성
		Function<Integer, Integer> f = i -> i / 10 * 10;  // i의 일의 자리를 제거

		List<Integer> list = new ArrayList<>();

		// Supplier를 이용하여 랜덤한 정수로 리스트 생성
		makeRandomList(s, list);
		System.out.println(list);

		// Predicate와 Consumer를 이용하여 짝수 출력
		printEvenNum(p, c, list);

		// Function을 이용하여 일의 자리를 제거한 새로운 리스트 생성
		List<Integer> newList = doSomething(f, list);
		System.out.println(newList);
	}

	// 주어진 Function을 사용하여 리스트 요소에 변환 작업을 수행하는 메서드
	static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
		List<T> newList = new ArrayList<T>(list.size());

		for (T i : list) {
			newList.add(f.apply(i));
		}

		return newList;
	}

	// 주어진 Predicate와 Consumer를 사용하여 짝수 요소를 출력하는 메서드
	static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
		System.out.print("[");
		for (T i : list) {
			if (p.test(i)) {
				c.accept(i);
			}
		}
		System.out.println("]");
	}

	// 주어진 Supplier를 사용하여 랜덤한 요소로 리스트를 생성하는 메서드
	static <T> void makeRandomList(Supplier<T> s, List<T> list) {
		for (int i = 0; i < 10; i++) {
			list.add(s.get());
		}
	}
}
