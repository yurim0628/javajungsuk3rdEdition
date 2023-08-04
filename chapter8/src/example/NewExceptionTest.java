package example;

class NewExceptionTest {
	public static void main(String args[]) {
		try {
			startInstall();     // 설치 프로세스를 시작합니다.
			copyFiles();        // 파일을 복사합니다.
		} catch (SpaceException e) {
			System.out.println("SpaceException 발생 : " + e.getMessage());
			e.printStackTrace();
			System.out.println("추후 확인을 위해 다시 설치를 시도합니다.");
		} catch (MemoryException me) {
			System.out.println("MemoryException 발생 : " + me.getMessage());
			me.printStackTrace();
			System.gc();     // Garbage Collection을 호출하여 메모리를 해제합니다.
			System.out.println("다시 설치를 시도합니다.");
		} finally {
			deleteTempFiles();  // 설치 프로세스 종료 후에 임시 파일을 삭제합니다.
		} // try-catch 끝
	} // main 메서드 끝

	static void startInstall() throws SpaceException, MemoryException {
		if (!enoughSpace())  // 충분한 공간이 없으면 SpaceException을 발생시킵니다.
			throw new SpaceException("공간이 부족합니다.");
		if (!enoughMemory()) // 충분한 메모리가 없으면 MemoryException을 발생시킵니다.
			throw new MemoryException("메모리가 부족합니다.");
	} // startInstall 메서드 끝

	static void copyFiles() { /* 파일을 복사하는 코드가 여기에 위치할 것입니다. */ }

	static void deleteTempFiles() { /* 임시 파일을 삭제하는 코드가 여기에 위치할 것입니다. */}

	static boolean enoughSpace() {
		// 충분한 공간이 있는지 확인하는 코드가 여기에 위치할 것입니다.
		return false;
	}

	static boolean enoughMemory() {
		// 충분한 메모리가 있는지 확인하는 코드가 여기에 위치할 것입니다.
		return true;
	}
} // ExceptionTest 클래스 끝

class SpaceException extends Exception {
	SpaceException(String msg) {
		super(msg);
	}
}

class MemoryException extends Exception {
	MemoryException(String msg) {
		super(msg);
	}
}
