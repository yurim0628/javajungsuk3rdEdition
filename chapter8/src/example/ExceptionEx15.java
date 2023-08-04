package example;

import java.io.*;

class ExceptionEx15 {
	public static void main(String[] args) {
		// command line으로부터 입력된 파일 이름을 사용하여 파일을 생성합니다.
		File f = createFile(args[0]);
		System.out.println( f.getName() + " 파일이 성공적으로 생성되었습니다.");
	} // main 메서드 끝

	static File createFile(String fileName) {
		try {
			if (fileName == null || fileName.equals(""))
				throw new Exception("유효하지 않은 파일 이름입니다.");
		} catch (Exception e) {
			// fileName이 비어있거나 null인 경우, 파일 이름을 '기본파일명.txt'로 설정합니다.
			fileName = "기본파일명.txt";
		} finally {
			File f = new File(fileName); // File 클래스의 인스턴스를 생성합니다.
			createNewFile(f);		    // 생성된 인스턴스를 이용하여 파일을 생성합니다.
			return f;
		}
	}	// createFile 메서드 끝

	static void createNewFile(File f) {
		try {
			f.createNewFile();		// 파일을 생성합니다.
		} catch(Exception e){ }
	}	// createNewFile 메서드 끝
}
