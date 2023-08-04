package example;

class ExceptionEx12 {
	public static void main(String[] args) throws Exception {
		method1();	// method1()을 호출하면서 예외 처리를 main 메서드로 던지도록 선언
	}	// main 메서드 끝

	static void method1() throws Exception {
		method2();
	}	// method1 메서드 끝

	static void method2() throws Exception {
		throw new Exception(); // Exception 예외를 발생시킴
	}	// method2 메서드 끝
}
