package example;

import java.io.*;

class RandomAccessFileEx2 {
	public static void main(String args[]) {
		int[] score = {
				1, 100,  90,  90,
				2,  70,  90, 100,
				3, 100, 100, 100,
				4,  70,  60,  80,
				5,  70,  90, 100
		};

		try {
			// "score2.dat" 파일을 생성하거나 열고, 읽고 쓰기가 가능한 RandomAccessFile 객체를 생성합니다.
			// "rw" 옵션은 읽고 쓰기가 가능하다는 의미입니다.
			RandomAccessFile raf = new RandomAccessFile("score2.dat", "rw");

			// 데이터 배열 score의 요소를 순회하며 순서대로 파일에 기록합니다.
			for (int i = 0; i < score.length; i++) {
				raf.writeInt(score[i]);
			}

			// 파일 포인터가 파일의 끝에 도달할 때까지 반복하여 파일에서 데이터를 읽어옵니다.
			// 파일의 끝에 도달하면 EOFException이 발생하며 반복문을 종료합니다.
			while (true) {
				System.out.println(raf.readInt());
			}
		} catch (EOFException eof) {
			// readInt() 메서드가 더 이상 읽을 데이터가 없을 때 EOFException이 발생합니다.
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // main
}
