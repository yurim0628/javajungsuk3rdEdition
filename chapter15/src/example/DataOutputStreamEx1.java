package example;

import java.io.*;

class DataOutputStreamEx1 {
	public static void main(String args[]) {
		FileOutputStream fos = null; // 파일에 데이터를 쓰기 위한 FileOutputStream 객체
		DataOutputStream dos = null; // 기본 데이터 타입을 쓰기 위한 DataOutputStream 객체

		try {
			fos = new FileOutputStream("sample.dat"); // "sample.dat" 파일에 데이터를 쓰기 위해 FileOutputStream 객체를 생성합니다.
			dos = new DataOutputStream(fos); // DataOutputStream을 생성하여 FileOutputStream으로부터 데이터를 쓰기 준비합니다.

			dos.writeInt(10); // int 값 10을 쓰기 준비합니다.
			dos.writeFloat(20.0f); // float 값 20.0을 쓰기 준비합니다.
			dos.writeBoolean(true); // boolean 값 true를 쓰기 준비합니다.

			dos.close(); // DataOutputStream을 닫습니다. 이때 내부적으로 FileOutputStream도 닫힙니다.
		} catch (IOException e) {
			// 입출력 예외가 발생할 경우 해당 예외를 출력합니다.
			e.printStackTrace();
		}
	} // main
}
