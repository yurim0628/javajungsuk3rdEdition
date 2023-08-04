package example;

class ExceptionEx14 {
	public static void main(String[] args) {
		try  {
			method1();	// method1()을 호출하면서 예외 처리를 시도합니다.
		} catch (Exception e) {
			System.out.println("main 메서드에서 예외가 처리되었습니다."); // catch 블록에서 예외가 처리되었다는 메시지를 출력합니다.
			e.printStackTrace(); // 예외 정보를 자세하게 출력합니다.
		}
	} // main 메서드 끝

	static void method1() throws Exception {
		throw new Exception(); // Exception 예외를 발생시킵니다.
	} // method1 메서드 끝
} // 클래스 끝
