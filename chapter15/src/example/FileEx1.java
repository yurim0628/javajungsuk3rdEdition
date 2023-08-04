package example;

import java.io.*;

class FileEx1 {
	public static void main(String[] args) throws IOException {
		File f = new File("c:\\jdk1.8\\work\\ch15\\FileEx1.java"); // "c:\jdk1.8\work\ch15\FileEx1.java" 경로의 파일을 나타내는 File 객체를 생성합니다.
		String fileName = f.getName(); // 파일의 이름을 가져옵니다.
		int pos = fileName.lastIndexOf("."); // 파일 이름에서 마지막 '.'의 위치를 찾습니다.

		System.out.println("파일의 이름 - " + f.getName()); // 파일의 이름을 출력합니다.
		System.out.println("확장자를 제외한 파일의 이름 - " + fileName.substring(0, pos)); // 확장자를 제외한 파일의 이름을 출력합니다.
		System.out.println("확장자 - " + fileName.substring(pos + 1)); // 확장자를 출력합니다.

		System.out.println("파일의 경로 - " + f.getPath()); // 파일의 경로를 출력합니다.
		System.out.println("절대 경로 - " + f.getAbsolutePath()); // 파일의 절대 경로를 출력합니다.
		System.out.println("정규화된 경로 - " + f.getCanonicalPath()); // 파일의 정규화된 경로를 출력합니다.
		System.out.println("부모 디렉토리 - " + f.getParent()); // 부모 디렉토리의 경로를 출력합니다.
		System.out.println();
		System.out.println("File.pathSeparator - " + File.pathSeparator); // 파일 경로들을 구분하는데 사용되는 경로 분리자를 출력합니다.
		System.out.println("File.pathSeparatorChar - " + File.pathSeparatorChar); // 파일 경로들을 구분하는데 사용되는 경로 분리자 문자를 출력합니다.
		System.out.println("File.separator - " + File.separator); // 파일 경로의 구성 요소를 구분하는데 사용되는 디렉토리 구분자를 출력합니다.
		System.out.println("File.separatorChar - " + File.separatorChar); // 파일 경로의 구성 요소를 구분하는데 사용되는 디렉토리 구분자 문자를 출력합니다.
		System.out.println();
		System.out.println("user.dir=" + System.getProperty("user.dir")); // 현재 작업 디렉토리를 출력합니다.
		System.out.println("sun.boot.class.path=" + System.getProperty("sun.boot.class.path")); // 시스템 속성 중 sun.boot.class.path를 출력합니다.
	}
}
