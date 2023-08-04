package example;

@FunctionalInterface
interface MyFunction {
	void run();  // 단 하나의 추상 메서드를 가지는 함수형 인터페이스
}

class LambdaEx1 {
	// MyFunction 매개변수를 받아서 그의 run() 메서드를 실행하는 정적 메서드
	static void execute(MyFunction f) {
		f.run();
	}

	// MyFunction 인스턴스를 반환하는 정적 메서드
	static MyFunction getMyFunction() {
		MyFunction f = () -> System.out.println("f3.run()");
		return f;
	}

	public static void main(String[] args) {
		// MyFunction의 run() 메서드를 구현하는 람다식
		MyFunction f1 = () -> System.out.println("f1.run()");

		// MyFunction의 run() 메서드를 구현하는 익명 클래스
		MyFunction f2 = new MyFunction() {
			public void run() {
				System.out.println("f2.run()");
			}
		};

		MyFunction f3 = getMyFunction();  // 메서드를 통해 MyFunction 인스턴스 가져오기

		f1.run();  // f1의 run() 호출: 출력 - f1.run()
		f2.run();  // f2의 run() 호출: 출력 - f2.run()
		f3.run();  // f3의 run() 호출: 출력 - f3.run()

		execute(f1);  // f1을 이용하여 execute() 호출: 출력 - f1.run()
		execute(() -> System.out.println("run()"));  // 람다식으로 execute() 호출: 출력 - run()
	}
}