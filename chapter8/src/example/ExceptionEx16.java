package example;

import java.io.*;

class ExceptionEx16 {
	public static void main(String[] args) {
		try {
			File f = createFile(args[0]); // 명령줄로부터 입력된 파일 이름을 사용하여 파일을 생성합니다.
			System.out.println(f.getName() + " 파일이 성공적으로 생성되었습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage() + " 다시 입력해 주세요.");
		}
	} // main 메서드 끝

	static File createFile(String fileName) throws Exception {
		if (fileName == null || fileName.equals(""))
			throw new Exception("유효하지 않은 파일 이름입니다."); // 파일 이름이 유효하지 않은 경우 예외를 발생시킵니다.
		File f = new File(fileName); // File 클래스의 인스턴스를 생성합니다.
		f.createNewFile(); // 생성된 인스턴스를 이용하여 파일을 생성합니다.
		return f; // 생성된 파일 인스턴스를 반환합니다.
	} // createFile 메서드 끝
} // 클래스 끝
