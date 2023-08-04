package example;

import java.io.*;

class StandardIOEx1 {
	public static void main(String[] args) {
		try {
			int input = 0;

			// 표준 입력(System.in)으로부터 문자를 읽어들임
			while ((input = System.in.read()) != -1) {
				// 읽어온 문자와 해당 문자의 ASCII 코드를 출력
				System.out.println("input: " + input + ", (char)input: " + (char) input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // main
}
