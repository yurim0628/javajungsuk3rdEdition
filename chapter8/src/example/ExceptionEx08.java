package example;

class ExceptionEx08 {
	public static void main(String args[]) {
		System.out.println(1);	// 1을 출력
		System.out.println(2);	// 2를 출력

		try {
			System.out.println(3);	// 3을 출력
			System.out.println(0/0);	// 0으로 나누기 연산을 수행하여 예외 발생
			System.out.println(4);	// 이 부분은 실행되지 않음 (예외 발생으로 인해 건너뜀)
		} catch (ArithmeticException ae)	{	// ArithmeticException을 잡기 위한 catch 블록
			ae.printStackTrace();	// 예외 정보 출력
			System.out.println("예외메시지 : " + ae.getMessage());	// 예외의 메시지 출력
		}	// try-catch 블록 끝

		System.out.println(6);	// 6을 출력
	}	// main 메서드 끝
}
