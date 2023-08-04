package example;

class FinallyTest3 {
	public static void main(String args[]) {
		// method1()을 호출합니다. (FinallyTest3 클래스의 메서드이므로 클래스 이름으로 호출)
		FinallyTest3.method1();
		System.out.println("method1() 호출이 끝난 후에 main 메서드가 실행됩니다.");
	} // main 메서드 끝

	static void method1() {
		try {
			System.out.println("method1()이 실행되었습니다.");
			return; // 메서드가 종료되기 전에 return 문을 사용하여 메서드를 빠져나갑니다.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("method1()의 finally 블록이 실행되었습니다.");
		}
	} // method1 메서드 끝
}
