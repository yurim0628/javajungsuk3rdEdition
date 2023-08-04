package example;

import java.io.*;

class FileEx2 {
	public static void main(String[] args) {
		if (args.length != 1) { // 프로그램 실행 시 디렉토리를 인자로 전달하지 않은 경우
			System.out.println("USAGE : java FileEx2 DIRECTORY"); // 사용법을 출력합니다.
			System.exit(0); // 프로그램을 종료합니다.
		}

		File f = new File(args[0]); // 인자로 전달받은 디렉토리 경로를 File 객체로 생성합니다.

		if (!f.exists() || !f.isDirectory()) { // 해당 경로가 존재하지 않거나 디렉토리가 아닌 경우
			System.out.println("유효하지 않은 디렉토리입니다."); // 메시지를 출력합니다.
			System.exit(0); // 프로그램을 종료합니다.
		}

		File[] files = f.listFiles(); // 디렉토리의 파일과 디렉토리 목록을 배열로 얻어옵니다.

		for (int i = 0; i < files.length; i++) { // 배열의 각 요소에 대해 반복하면서
			String fileName = files[i].getName(); // 파일 또는 디렉토리 이름을 가져옵니다.
			System.out.println(files[i].isDirectory() ? "[" + fileName + "]" : fileName);
			// 해당 요소가 디렉토리라면 "[파일이름]" 형식으로 출력하고, 아니라면 파일 이름만 출력합니다.
		}
	} // main
}
