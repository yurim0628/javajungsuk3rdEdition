package example;

import java.io.*;

class FileEx8 {
	static int deletedFiles = 0;

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("USAGE : java FileEx8 Extension");
			System.exit(0);
		}

		String currDir = System.getProperty("user.dir"); // 현재 작업 디렉토리의 경로를 얻어옵니다.

		File dir = new File(currDir); // 현재 작업 디렉토리를 나타내는 File 객체를 생성합니다.
		String ext = "." + args[0]; // 사용자가 입력한 확장자를 저장합니다.

		delete(dir, ext); // 현재 작업 디렉토리와 확장자를 가진 파일들을 삭제하는 메서드 호출
		System.out.println(deletedFiles + "개의 파일이 삭제되었습니다.");
	} // end of main

	public static void delete(File dir, String ext) {
		File[] files = dir.listFiles(); // 현재 디렉토리의 파일과 디렉토리 목록을 배열로 얻어옵니다.

		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) { // 파일이 디렉토리인 경우
				delete(files[i], ext); // 재귀적으로 하위 디렉토리에서도 파일 삭제를 시도합니다.
			} else { // 파일인 경우
				String filename = files[i].getAbsolutePath(); // 파일의 절대 경로를 얻어옵니다.

				if (filename.endsWith(ext)) { // 파일의 확장자가 사용자가 입력한 확장자와 일치하는지 확인합니다.
					System.out.print(filename);
					if (files[i].delete()) { // 파일 삭제 시도
						System.out.println(" - 삭제 성공");
						deletedFiles++; // 삭제 성공하면 삭제된 파일 개수를 증가시킵니다.
					} else {
						System.out.println(" - 삭제 실패");
					}
				} // if(filename.endsWith(ext))
			} // if(files[i].isDirectory())
		} // for(int i=0; i < files.length; i++)
	} // end of delete
} // end of class
