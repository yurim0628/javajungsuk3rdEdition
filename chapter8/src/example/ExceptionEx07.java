package example;

class ExceptionEx07 {
	public static void main(String args[]) {
		System.out.println(1);	// 1을 출력
		System.out.println(2);	// 2를 출력

		try {
			System.out.println(3);	// 3을 출력
			System.out.println(0/0);	// 0으로 나누기 연산을 수행하여 예외 발생
			System.out.println(4);	// 이 부분은 실행되지 않음 (예외 발생으로 인해 건너뜀)
		} catch (ArithmeticException ae)	{	// ArithmeticException을 잡기 위한 catch 블록
			if (ae instanceof ArithmeticException)
				System.out.println("true");	// ae가 ArithmeticException 타입인지 확인 후 "true"를 출력
			System.out.println("ArithmeticException");	// "ArithmeticException"을 출력
		} catch (Exception e)	{	// 모든 예외를 잡기 위한 catch 블록
			System.out.println("Exception");	// "Exception"을 출력
		}	// try-catch 블록 끝

		System.out.println(6);	// 6을 출력
	}	// main 메서드 끝
}
