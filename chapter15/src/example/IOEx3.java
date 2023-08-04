package example;

import java.io.*;
import java.util.Arrays;

class IOEx3 {
	public static void main(String[] args) {
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc = null;

		byte[] temp = new byte[4];    // 읽어들일 데이터를 저장할 배열

		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;

		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();

		System.out.println("Input Source  :" + Arrays.toString(inSrc));

		try {
			while (input.available() > 0) {
				int bytesRead = input.read(temp); // 읽어들인 데이터를 temp 배열에 저장
				output.write(temp, 0, bytesRead); // temp 배열에 있는 bytesRead만큼의 데이터를 output에 씀
				outSrc = output.toByteArray(); // output에 쓰인 데이터를 byte 배열로 변환
				printArrays(temp, outSrc);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // main

	static void printArrays(byte[] temp, byte[] outSrc) {
		System.out.println("temp          :" + Arrays.toString(temp));
		System.out.println("Output Source :" + Arrays.toString(outSrc));
	}
}
