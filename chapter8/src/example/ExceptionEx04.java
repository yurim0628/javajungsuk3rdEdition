package example;

class ExceptionEx04 {
	public static void main(String args[]) {
		System.out.println(1);	// 1을 출력
		System.out.println(2);	// 2를 출력

		try {
			System.out.println(3);	// 3을 출력
			System.out.println(4);	// 4를 출력
		} catch (Exception e)	{
			System.out.println(5);	// 예외가 발생하면 5를 출력
		} // try-catch 블록 끝

		System.out.println(6);	// 6을 출력
	}	// main 메서드 끝
}
