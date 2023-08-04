package example;

import java.io.*;

class BufferedOutputStreamEx1 {
	public static void main(String args[]) {
		try {
			// 파일에 데이터를 쓰기 위해 FileOutputStream 객체를 생성합니다. 이때 파일명은 "123.txt"로 지정됩니다.
			FileOutputStream fos = new FileOutputStream("123.txt");

			// BufferedOutputStream을 생성합니다. 버퍼 크기가 8192로 설정되었습니다. (일반적으로 큰 값이 효율적입니다.)
			BufferedOutputStream bos = new BufferedOutputStream(fos, 8192);

			// 반복문을 통해 숫자 1부터 9까지를 ASCII 코드로 변환하여 BufferedOutputStream에 씁니다.
			for (int i = '1'; i <= '9'; i++) {
				bos.write(i);
			}

			// BufferedOutputStream을 닫습니다. 이때 내부적으로 FileOutputStream도 닫힙니다.
			bos.close();
		} catch (IOException e) {
			// 입출력 예외가 발생할 경우 해당 예외를 출력합니다.
			e.printStackTrace();
		}
	}
}
