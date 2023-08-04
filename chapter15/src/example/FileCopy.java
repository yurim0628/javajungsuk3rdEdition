package example;

import java.io.*;

class FileCopy {
	public static void main(String args[]) {
		try {
			FileInputStream fis = new FileInputStream(args[0]); // 입력 파일로부터 데이터를 읽기 위한 FileInputStream 객체를 생성합니다.
			FileOutputStream fos = new FileOutputStream(args[1]); // 출력 파일에 데이터를 쓰기 위한 FileOutputStream 객체를 생성합니다.

			int data = 0;
			while ((data = fis.read()) != -1) {
				fos.write(data); // 읽어온 데이터를 출력 파일에 씁니다. (void write(int b) 메서드를 사용합니다.)
			}

			fis.close(); // 입력 파일을 닫습니다.
			fos.close(); // 출력 파일을 닫습니다.
		} catch (IOException e) {
			// 입출력 예외가 발생할 경우 해당 예외를 출력합니다.
			e.printStackTrace();
		}
	}
}
