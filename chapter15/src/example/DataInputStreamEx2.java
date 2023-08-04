package example;

import java.io.*;

class DataInputStreamEx2 {
	public static void main(String args[]) {
		int sum = 0; // 점수들의 합을 저장할 변수
		int score = 0; // 읽어온 점수를 저장할 변수

		FileInputStream fis = null; // 파일을 읽기 위한 FileInputStream 객체
		DataInputStream dis = null; // 기본 데이터 타입을 읽기 위한 DataInputStream 객체

		try {
			fis = new FileInputStream("score.dat"); // "score.dat" 파일을 읽기 위해 FileInputStream 객체를 생성합니다.
			dis = new DataInputStream(fis); // DataInputStream을 생성하여 FileInputStream으로부터 데이터를 읽습니다.

			while (true) {
				score = dis.readInt(); // DataInputStream으로부터 int 값 하나를 읽어옵니다.
				System.out.println(score); // 읽어온 점수를 출력합니다.
				sum += score; // 읽어온 점수를 합계에 더합니다.
			}
		} catch (EOFException e) {
			// EOFException은 파일의 끝(End of File)에 도달하여 더 이상 읽을 데이터가 없을 때 발생합니다.
			// 반복문에서 계속 읽다가 EOFException이 발생하면 반복문을 빠져나가고, 합계를 출력합니다.
			System.out.println("모든 점수의 합은 " + sum + "입니다.");
		} catch (IOException ie) {
			// 입출력 예외가 발생할 경우 해당 예외를 출력합니다.
			ie.printStackTrace();
		} finally {
			// 파일을 닫습니다.
			try {
				if (dis != null)
					dis.close();
			} catch (IOException ie) {
				ie.printStackTrace();
			}
		} // try
	} // main
}
