package example;

import java.io.*;

class RandomAccessFileEx1 {
	public static void main(String[] args) {
		try {
			// "test.dat" 파일을 생성하거나 열고, 읽고 쓰기가 가능한 RandomAccessFile 객체를 생성합니다.
			// "rw" 옵션은 읽고 쓰기가 가능하다는 의미입니다.
			RandomAccessFile raf = new RandomAccessFile("test.dat", "rw");

			// 현재 파일 내의 위치(파일 포인터)를 출력합니다. 파일이 처음 생성되었기 때문에 위치는 0입니다.
			System.out.println("현재 파일 포인터 위치: " + raf.getFilePointer());

			// 4바이트 크기의 정수 값을 파일에 기록합니다. 이때 파일 포인터가 4만큼 증가합니다.
			raf.writeInt(100);

			// 다시 파일 포인터의 위치를 출력합니다. 정수 값이 4바이트 크기이므로 위치는 4가 됩니다.
			System.out.println("현재 파일 포인터 위치: " + raf.getFilePointer());

			// 8바이트 크기의 long 값(정수)을 파일에 기록합니다. 이때 파일 포인터가 8만큼 증가합니다.
			raf.writeLong(100L);

			// 마지막으로 파일 포인터의 위치를 출력합니다. long 값이 8바이트 크기이므로 위치는 12가 됩니다.
			System.out.println("현재 파일 포인터 위치: " + raf.getFilePointer());

			// RandomAccessFile을 사용한 후에는 반드시 close() 메서드를 호출하여 파일을 닫아줍니다.
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
