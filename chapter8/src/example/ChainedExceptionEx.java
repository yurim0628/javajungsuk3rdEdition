package example;

class ChainedExceptionEx {
	public static void main(String args[]) {
		try {
			install();
		} catch(InstallException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	// 설치 메서드
	static void install() throws InstallException {
		try {
			startInstall();     // 프로그램을 설치하는 메서드 호출
			copyFiles();        // 파일들을 복사함
		} catch (SpaceException2 e)    {
			InstallException ie = new InstallException("공간 부족 예외");
			ie.initCause(e); // 예외의 원인을 설정하여 체인 연결
			throw ie; // 새로운 InstallException을 던짐
		} catch (MemoryException2 me) {
			InstallException ie = new InstallException("메모리 부족 예외");
			ie.initCause(me); // 예외의 원인을 설정하여 체인 연결
			throw ie; // 새로운 InstallException을 던짐
		} finally {
			deleteTempFiles();  // 프로그램 설치 과정에서 생성한 임시 파일들을 삭제함
		}
	}

	// 프로그램 설치를 시작하는 메서드
	static void startInstall() throws SpaceException2, MemoryException2 {
		if (!enoughSpace()) {    // 충분한 공간이 없으면 SpaceException2 예외를 던짐
			throw new SpaceException2("공간이 부족합니다.");
		}

		if (!enoughMemory()) {  // 충분한 메모리가 없으면 MemoryException2 예외를 던짐
			throw new MemoryException2("메모리가 부족합니다.");
			// throw new RuntimeException(new MemoryException("메모리가 부족합니다."));
		}
	}

	// 파일들을 복사하는 메서드
	static void copyFiles() { /* 파일 복사 관련 코드가 들어갈 것입니다. */ }

	// 설치 과정에서 생성한 임시 파일들을 삭제하는 메서드
	static void deleteTempFiles() { /* 임시 파일 삭제 관련 코드가 들어갈 것입니다. */}

	// 충분한 공간이 있는지 확인하는 메서드
	static boolean enoughSpace() {
		// 설치할 공간의 여유가 있는지 확인하는 코드가 들어갈 것입니다.
		return false;
	}

	// 충분한 메모리가 있는지 확인하는 메서드
	static boolean enoughMemory() {
		// 설치를 위해 충분한 메모리가 있는지 확인하는 코드가 들어갈 것입니다.
		return true;
	}
}

// 설치 예외 클래스
class InstallException extends Exception {
	InstallException(String msg) {
		super(msg);
	}
}

// 공간 부족 예외 클래스
class SpaceException2 extends Exception {
	SpaceException2(String msg) {
		super(msg);
	}
}

// 메모리 부족 예외 클래스
class MemoryException2 extends Exception {
	MemoryException2(String msg) {
		super(msg);
	}
}
