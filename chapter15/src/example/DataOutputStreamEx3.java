package example;

import java.io.*;

class DataOutputStreamEx3 {
	public static void main(String args[]) {
		int[] score = { 100, 90, 95, 85, 50 }; // 점수들을 저장하는 int 배열

		try {
			FileOutputStream fos = new FileOutputStream("score.dat"); // "score.dat" 파일에 데이터를 쓰기 위해 FileOutputStream 객체를 생성합니다.
			DataOutputStream dos = new DataOutputStream(fos); // DataOutputStream을 생성하여 FileOutputStream으로부터 데이터를 쓰기 준비합니다.

			// for 문을 통해 int 배열에 저장된 점수들을 파일에 씁니다.
			for (int i = 0; i < score.length; i++) {
				dos.writeInt(score[i]); // int 값(score[i])을 쓰기 준비합니다.
			}

			dos.close(); // DataOutputStream을 닫습니다. 이때 내부적으로 FileOutputStream도 닫힙니다.
		} catch (IOException e) {
			// 입출력 예외가 발생할 경우 해당 예외를 출력합니다.
			e.printStackTrace();
		}
	} // main
}
