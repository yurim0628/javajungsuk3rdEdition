package example;

import java.io.*;

class FileViewer {
	public static void main(String args[]) throws IOException {
		FileInputStream fis = new FileInputStream(args[0]); // args[0]으로 지정된 파일을 읽기 위해 FileInputStream 객체를 생성합니다.
		int data = 0;

		while ((data = fis.read()) != -1) { // 파일의 끝까지 문자를 읽어서 콘솔에 출력합니다.
			char c = (char) data; // 읽은 데이터를 문자로 변환합니다.
			System.out.print(c); // 읽은 문자를 콘솔에 출력합니다.
		}

		fis.close(); // 파일을 다 읽었으므로 FileInputStream을 닫습니다.
	}
}
