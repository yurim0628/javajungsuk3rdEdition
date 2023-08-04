package example;

import java.io.*;

class StandardIOEx3 {
	public static void main(String[] args) {
		PrintStream ps = null;
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream("test.txt");
			ps = new PrintStream(fos);
			System.setOut(ps); // System.out의 출력을 test.txt 파일로 변경
		} catch (FileNotFoundException e) {
			System.err.println("File not found.");
		}

		System.out.println("Hello by System.out"); // 파일 test.txt에 출력됨
		System.err.println("Hello by System.err"); // 표준 오류 출력으로 남겨짐
	}
}

