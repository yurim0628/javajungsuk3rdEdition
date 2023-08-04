package example;

import java.util.function.*;
import java.util.*;

class LambdaEx6 {
	public static void main(String[] args) {
		// IntSupplier 함수형 인터페이스로 랜덤한 정수 생성
		IntSupplier s = () -> (int) (Math.random() * 100) + 1;

		// IntConsumer 함수형 인터페이스로 정수 출력
		IntConsumer c = i -> System.out.print(i + ", ");

		// IntPredicate 함수형 인터페이스로 짝수 판별
		IntPredicate p = i -> i % 2 == 0;

		// IntUnaryOperator 함수형 인터페이스로 일의 자리를 제거하는 함수 생성
		IntUnaryOperator op = i -> i / 10 * 10;  // i의 일의 자리를 제거

		int[] arr = new int[10];

		// IntSupplier를 이용하여 랜덤한 정수로 배열 생성
		makeRandomList(s, arr);
		System.out.println(Arrays.toString(arr));

		// IntPredicate와 IntConsumer를 이용하여 짝수 출력
		printEvenNum(p, c, arr);

		// IntUnaryOperator를 이용하여 일의 자리를 제거한 새로운 배열 생성
		int[] newArr = doSomething(op, arr);
		System.out.println(Arrays.toString(newArr));
	}

	// 주어진 IntSupplier를 사용하여 정수 배열에 랜덤한 요소로 채우는 메서드
	static void makeRandomList(IntSupplier s, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.getAsInt();  // get() 대신 getAsInt()를 사용
		}
	}

	// 주어진 IntPredicate와 IntConsumer를 사용하여 짝수 요소를 출력하는 메서드
	static void printEvenNum(IntPredicate p, IntConsumer c, int[] arr) {
		System.out.print("[");
		for (int i : arr) {
			if (p.test(i)) {
				c.accept(i);
			}
		}
		System.out.println("]");
	}

	// 주어진 IntUnaryOperator를 사용하여 배열 요소에 변환 작업을 수행하는 메서드
	static int[] doSomething(IntUnaryOperator op, int[] arr) {
		int[] newArr = new int[arr.length];

		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = op.applyAsInt(arr[i]);  // apply() 대신 applyAsInt()를 사용
		}

		return newArr;
	}
}
