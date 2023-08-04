package example;

@FunctionalInterface
interface MyFunction {
	void myMethod();  // 하나의 추상 메서드를 가진 함수형 인터페이스
}

class LambdaEx2 {
	public static void main(String[] args) {
		MyFunction f = () -> {};  // 람다식을 생성하여 MyFunction 변수에 할당
		Object obj = (MyFunction) (() -> {});  // 람다식을 MyFunction으로 캐스팅하고, 그 후 Object로 캐스팅 (암묵적 캐스팅)
		String str = ((Object) (MyFunction) (() -> {})).toString();  // 람다식을 MyFunction으로, 그 후 Object로 캐스팅하고, 마지막으로 toString() 호출

		System.out.println(f);   // MyFunction 인스턴스 (람다식) 출력: 결과 - example.LambdaEx2$$Lambda$1/0x0000000800060840@6d6f6e28
		System.out.println(obj); // Object 인스턴스 출력: 결과 - example.LambdaEx2$$Lambda$1/0x0000000800060840@6d6f6e28
		System.out.println(str); // Object 인스턴스의 toString() 결과 출력: 결과 - example.LambdaEx2$$Lambda$1/0x0000000800060840@6d6f6e28

		System.out.println((MyFunction) (() -> {}));  // 람다식을 바로 MyFunction으로 캐스팅하여 출력: 결과 - example.LambdaEx2$$Lambda$1/0x0000000800060840@6d6f6e28
		System.out.println(((Object) (MyFunction) (() -> {})).toString());  // 람다식을 MyFunction으로, 그 후 Object로 캐스팅하고, 마지막으로 toString() 호출하여 출력: 결과 - example.LambdaEx2$$Lambda$1/0x0000000800060840@6d6f6e28
	}
}
