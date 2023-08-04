package example;

import java.io.*;
import java.util.*;

class SequenceInputStreamEx {
	public static void main(String[] args) {
		byte[] arr1 = {0, 1, 2};
		byte[] arr2 = {3, 4, 5};
		byte[] arr3 = {6, 7, 8};
		byte[] outSrc = null;

		// 바이트 배열들을 저장할 Vector를 생성하고, 각 배열을 Vector에 추가합니다.
		Vector<InputStream> v = new Vector<>();
		v.add(new ByteArrayInputStream(arr1));
		v.add(new ByteArrayInputStream(arr2));
		v.add(new ByteArrayInputStream(arr3));

		// SequenceInputStream을 생성하여 Vector의 요소들을 연결합니다.
		SequenceInputStream input = new SequenceInputStream(v.elements());

		// 연결된 입력 스트림으로부터 데이터를 읽어서 새로운 배열에 저장합니다.
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		int data = 0;

		try {
			while ((data = input.read()) != -1) {
				output.write(data);	// void write(int b)
			}
		} catch (IOException e) {}

		// 결과로 생성된 새로운 배열을 얻습니다.
		outSrc = output.toByteArray();

		System.out.println("Input Source1  :" + Arrays.toString(arr1));
		System.out.println("Input Source2  :" + Arrays.toString(arr2));
		System.out.println("Input Source3  :" + Arrays.toString(arr3));
		System.out.println("Output Source  :" + Arrays.toString(outSrc));
	}
}

