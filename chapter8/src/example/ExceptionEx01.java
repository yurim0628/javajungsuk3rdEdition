package example;

class ExceptionEx01 {
	public static void main(String[] args)
	{
		try  {
			try	{	} catch (Exception e)	{ }
			// 첫 번째 try-catch 블록 내부의 빈 catch 블록이 실행됨
			// 내부의 catch 블록은 아무 동작도 하지 않으므로 아무런 일도 일어나지 않음
		} catch (Exception e)	{
			try	{	} catch (Exception e) { }
			// 외부의 try-catch 블록에서는 내부의 catch 블록의 예외와 충돌하는 이름의 변수 e를 가진 또 다른 내부의 try-catch 블록이 존재함
			// 이로 인해 컴파일 오류가 발생함 (또는 에러 메시지가 출력됨)
			// 내부와 외부의 catch 블록은 같은 이름의 변수 e를 가질 수 없음
		} // try-catch 블록 끝

		try  {

		} catch (Exception e)	{
			// 외부의 try-catch 블록은 문제 없이 정상적으로 동작함
			// 이 블록은 빈 상태이기 때문에 아무런 동작도 하지 않음
		} // try-catch 블록 끝
	}	// main 메서드 끝
}
