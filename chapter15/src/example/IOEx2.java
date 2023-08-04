package example;

import java.io.*;
import java.util.Arrays;

class IOEx2 {
	public static void main(String[] args) {
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc = null;

		byte[] temp = new byte[10];

		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;

		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();

		// inSrc에서 temp로 데이터를 읽어들입니다. 0부터 temp.length까지 읽어서 temp 배열에 저장합니다.
		input.read(temp, 0, temp.length);

		// temp 배열의 5번째 인덱스부터 5개의 데이터를 output에 씁니다.
		output.write(temp, 5, 5);

		outSrc = output.toByteArray(); // ByteArrayOutputStream에 쓰인 데이터를 byte 배열로 변환합니다.

		System.out.println("Input Source  :" + Arrays.toString(inSrc));
		System.out.println("temp          :" + Arrays.toString(temp));
		System.out.println("Output Source :" + Arrays.toString(outSrc));
	}
}
