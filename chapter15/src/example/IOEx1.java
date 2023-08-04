package example;

import java.io.*;
import java.util.Arrays;

class IOEx1 {
	public static void main(String[] args) {
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc = null;

		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;

		input = new ByteArrayInputStream(inSrc); // 입력 바이트 배열을 ByteArrayInputStream으로 감싸줍니다.
		output = new ByteArrayOutputStream(); // 출력 바이트 배열을 저장할 ByteArrayOutputStream을 생성합니다.

		int data = 0;

		while ((data = input.read()) != -1) {
			output.write(data); // 입력 바이트 배열의 데이터를 읽어서 출력 바이트 배열에 쓰기합니다.
		}

		outSrc = output.toByteArray(); // ByteArrayOutputStream에 쓰인 데이터를 byte 배열로 변환합니다.

		System.out.println("Input Source  :" + Arrays.toString(inSrc));
		System.out.println("Output Source :" + Arrays.toString(outSrc));
	}
}
