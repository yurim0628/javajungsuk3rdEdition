package example;

class ExceptionEx17 {
	public static void main(String[] args) {
		try {
			method1(); // method1()을 호출하면서 예외 처리를 시도합니다.
		} catch (Exception e) {
			System.out.println("main 메서드에서 예외가 처리되었습니다.");
		}
	} // main 메서드 끝

	static void method1() throws Exception {
		try {
			throw new Exception(); // Exception 예외를 발생시킵니다.
		} catch (Exception e) {
			System.out.println("method1 메서드에서 예외가 처리되었습니다.");
			throw e; // 다시 예외를 던집니다.
		}
	} // method1 메서드 끝
}

