package example;

import java.io.*;

class RandomAccessFileEx3 {
	public static void main(String args[]) {
		int sum = 0;

		try {
			RandomAccessFile raf = new RandomAccessFile("score2.dat", "r");
			int i = 4; // 파일에서 데이터를 읽기 시작할 위치를 나타내는 변수 i를 4로 초기화합니다.

			// 파일에서 데이터를 읽어와서 합계를 계산합니다.
			while (true) {
				raf.seek(i); // 파일 포인터를 i 위치로 이동합니다.
				sum += raf.readInt(); // 파일에서 int 형식의 데이터를 읽어와서 합계에 더합니다.
				i += 16; // 다음 데이터가 위치한 곳으로 이동합니다. (4개의 int 형식 데이터가 하나의 레코드를 구성하므로, 다음 레코드로 이동합니다.)
			}
		} catch (EOFException e) {
			// 파일의 끝에 도달하면 EOFException이 발생합니다. 이때, 합계를 출력합니다.
			System.out.println("sum : " + sum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
