package example;

import java.io.*;
import java.util.Arrays;

class IOEx4 {
	public static void main(String[] args) {
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc = null;

		byte[] temp = new byte[4];

		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;

		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();

		try {
			while (input.available() > 0) {
				int len = input.read(temp); // 실제로 읽은 데이터의 길이를 반환
				output.write(temp, 0, len); // 실제로 읽은 데이터만 output에 쓰기
			}
		} catch (IOException e) {
		}

		outSrc = output.toByteArray();

		System.out.println("Input Source  :" + Arrays.toString(inSrc));
		System.out.println("temp          :" + Arrays.toString(temp));
		System.out.println("Output Source :" + Arrays.toString(outSrc));
	}
}
