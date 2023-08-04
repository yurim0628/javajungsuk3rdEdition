package example;

import java.io.*;

class DataInputStreamEx1 {
	public static void main(String args[]) {
		try {
			// "sample.dat" 파일을 읽기 위해 FileInputStream 객체를 생성합니다.
			FileInputStream fis = new FileInputStream("sample.dat");

			// DataInputStream을 생성하여 FileInputStream으로부터 기본 데이터 타입을 읽습니다.
			DataInputStream dis = new DataInputStream(fis);

			// DataInputStream을 이용하여 각각 int, float, boolean 타입으로 데이터를 읽고 출력합니다.
			System.out.println(dis.readInt()); // int 값을 읽어와서 출력합니다.
			System.out.println(dis.readFloat()); // float 값을 읽어와서 출력합니다.
			System.out.println(dis.readBoolean()); // boolean 값을 읽어와서 출력합니다.

			// DataInputStream을 닫습니다.
			dis.close();
		} catch (IOException e) {
			// 입출력 예외가 발생할 경우 해당 예외를 출력합니다.
			e.printStackTrace();
		}
	} // main
}
