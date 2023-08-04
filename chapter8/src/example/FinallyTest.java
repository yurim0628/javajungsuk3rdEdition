package example;

class FinallyTest {
	public static void main(String args[]) {
		try {
			startInstall();     // 설치 프로세스를 시작합니다.
			copyFiles();        // 파일을 복사합니다.
			deleteTempFiles();  // 임시 파일을 삭제합니다.
		} catch (Exception e) {
			e.printStackTrace();  // 예외가 발생하면 예외 정보를 출력합니다.
			deleteTempFiles();    // 예외 처리 후에도 임시 파일을 삭제합니다.
		} // try-catch 끝
	} // main 메서드 끝

	static void startInstall() {
		/* 설치 프로세스를 시작하는 코드가 여기에 위치할 것입니다. */
	}
	static void copyFiles() { /* 파일을 복사하는 코드가 여기에 위치할 것입니다. */ }
	static void deleteTempFiles() { /* 임시 파일을 삭제하는 코드가 여기에 위치할 것입니다. */ }
}
