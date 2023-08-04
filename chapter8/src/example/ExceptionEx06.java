package example;

class ExceptionEx06 {
	public static void main(String args[]) {
		System.out.println(1);	// 1을 출력
		System.out.println(2);	// 2를 출력

		try {
			System.out.println(3);	// 3을 출력
			System.out.println(0/0);	// 0으로 나누기 연산을 수행하여 예외 발생
			System.out.println(4);	// 이 부분은 실행되지 않음 (예외 발생으로 인해 건너뜀)
		} catch (Exception e)	{	// 모든 예외를 처리하기 위해 Exception 클래스를 사용
			System.out.println(5);	// 예외가 발생하면 5를 출력
		}	// try-catch 블록 끝

		System.out.println(6);	// 6을 출력
	}	// main 메서드 끝
}
