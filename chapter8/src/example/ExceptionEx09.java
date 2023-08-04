package example;

class ExceptionEx09 {
	public static void main(String args[]) {
		try {
			Exception e = new Exception("사용자 정의 예외 발생.");
			throw e;	// 사용자 정의 예외를 발생시킴
			// throw new Exception("사용자 정의 예외 발생.");  // 위의 두 줄과 동일한 효과를 갖습니다.
		} catch (Exception e)	{
			System.out.println("예외 메시지 : " + e.getMessage()); // 예외의 메시지 출력
			e.printStackTrace(); // 예외 정보를 자세하게 출력
		}
		System.out.println("프로그램이 정상 종료되었습니다.");
	}
}
