package example;

import java.io.*;

class FileReaderEx1 {
	public static void main(String args[]) {
		try {
			String fileName = "test.txt"; // 읽을 파일의 이름을 지정합니다.
			FileInputStream fis = new FileInputStream(fileName); // FileInputStream 객체를 생성합니다.
			FileReader fr = new FileReader(fileName); // FileReader 객체를 생성합니다.

			int data = 0;

			// FileInputStream을 사용하여 파일을 읽고, 읽은 데이터를 문자로 변환하여 출력합니다.
			while ((data = fis.read()) != -1) {
				System.out.print((char) data);
			}
			System.out.println();
			fis.close(); // FileInputStream을 닫습니다.

			// FileReader를 사용하여 파일을 읽고, 읽은 데이터를 문자로 변환하여 출력합니다.
			while ((data = fr.read()) != -1) {
				System.out.print((char) data);
			}
			System.out.println();
			fr.close(); // FileReader를 닫습니다.

		} catch (IOException e) {
			e.printStackTrace();
		}
	} // main
}
