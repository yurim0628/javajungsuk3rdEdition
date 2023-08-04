package example;

import java.io.*;
import java.util.Arrays;

class DataOutputStreamEx2 {
	public static void main(String args[]) {
		ByteArrayOutputStream bos = null; // 데이터를 메모리에 쓰기 위한 ByteArrayOutputStream 객체
		DataOutputStream dos = null; // 기본 데이터 타입을 쓰기 위한 DataOutputStream 객체

		byte[] result = null; // ByteArrayOutputStream으로부터 얻어온 데이터를 저장할 배열

		try {
			bos = new ByteArrayOutputStream(); // 데이터를 메모리에 쓰기 위해 ByteArrayOutputStream 객체를 생성합니다.
			dos = new DataOutputStream(bos); // DataOutputStream을 생성하여 ByteArrayOutputStream으로부터 데이터를 쓰기 준비합니다.

			dos.writeInt(10); // int 값 10을 쓰기 준비합니다.
			dos.writeFloat(20.0f); // float 값 20.0을 쓰기 준비합니다.
			dos.writeBoolean(true); // boolean 값 true를 쓰기 준비합니다.

			result = bos.toByteArray(); // ByteArrayOutputStream으로부터 데이터를 byte 배열로 얻어옵니다.

			// byte 배열을 10진수로 출력합니다.
			System.out.println("10진수: " + Arrays.toString(result));

			// byte 배열을 16진수로 변환하여 출력합니다.
			String[] hex = new String[result.length];
			for (int i = 0; i < result.length; i++) {
				if (result[i] < 0) {
					// 음수인 경우에는 256을 더해 양수로 변환한 후, 2자리 16진수로 포맷팅합니다.
					hex[i] = String.format("%02x", result[i] + 256);
				} else {
					// 양수인 경우에는 그냥 2자리 16진수로 포맷팅합니다.
					hex[i] = String.format("%02x", result[i]);
				}
			}
			System.out.println("16진수: " + Arrays.toString(hex));

			dos.close(); // DataOutputStream을 닫습니다. 이때 내부적으로 ByteArrayOutputStream도 닫힙니다.
		} catch (IOException e) {
			// 입출력 예외가 발생할 경우 해당 예외를 출력합니다.
			e.printStackTrace();
		}
	} // main
}
