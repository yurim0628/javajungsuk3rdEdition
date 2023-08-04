package example;

import java.io.*;

class FileEx7 {
	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			System.out.println("USAGE : java FileEx7 pattern");
			System.exit(0);
		}

		String currDir = System.getProperty("user.dir"); // 현재 작업 디렉토리의 경로를 얻어옵니다.

		File dir = new File(currDir); // 현재 작업 디렉토리를 나타내는 File 객체를 생성합니다.
		final String pattern = args[0]; // 사용자가 입력한 패턴을 저장합니다.

		// File의 list 메서드를 사용하여 현재 작업 디렉토리에서 FilenameFilter를 구현한 객체를 이용하여 파일들의 배열을 가져옵니다.
		String[] files = dir.list(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.indexOf(pattern) != -1; // 파일 이름에 패턴이 포함되어 있는지 검사하여 true 또는 false를 반환합니다.
			}
		});

		for (int i = 0; i < files.length; i++) { // 찾은 파일들의 이름을 출력합니다.
			System.out.println(files[i]);
		}
	} // end of main
} // end of class
