package example;

import java.io.*;

class FileEx9 {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java FileEx9 DIRECTORY");
			System.exit(0);
		}

		File dir = new File(args[0]); // 사용자가 입력한 디렉토리 경로를 나타내는 File 객체를 생성합니다.

		if (!dir.exists() || !dir.isDirectory()) { // 디렉토리가 존재하는지, 디렉토리인지 확인합니다.
			System.out.println("유효하지 않은 디렉토리입니다.");
			System.exit(0);
		}

		File[] list = dir.listFiles(); // 디렉토리 내의 파일과 디렉토리 목록을 배열로 얻어옵니다.

		for (int i = 0; i < list.length; i++) { // 디렉토리 내의 모든 파일들을 반복하여 처리합니다.
			String fileName = list[i].getName(); // 파일의 이름을 얻어옵니다.
			// 파일 이름 앞에 "0000"을 추가하고, 새로운 파일 이름을 "0000" + 기존 파일 이름의 마지막 7자리로 설정합니다.
			String newFileName = "0000" + fileName;
			newFileName = newFileName.substring(newFileName.length() - 7);
			list[i].renameTo(new File(dir, newFileName)); // 새로운 파일 이름으로 파일을 이름 변경합니다.
		}
	} // end of main
} // end of FileEx9 class
