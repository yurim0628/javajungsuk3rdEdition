package example;

import java.io.*;

class BufferedReaderEx1 {
	public static void main(String[] args) {
		try {
			// "BufferedReaderEx1.java" 파일을 읽기 위해 FileReader 객체를 생성합니다.
			FileReader fr = new FileReader("BufferedReaderEx1.java");

			// BufferedReader를 생성하여 FileReader로부터 읽은 데이터를 버퍼링합니다.
			BufferedReader br = new BufferedReader(fr);

			// 한 줄씩 읽어올 문자열을 담을 변수를 선언합니다.
			String line = "";

			// 반복문을 통해 파일의 모든 내용을 한 줄씩 읽어옵니다. 또한 읽은 줄의 번호도 함께 출력합니다.
			for (int i = 1; (line = br.readLine()) != null; i++) {
				// 읽은 줄에서 ";" 문자가 있는지 검사하여 있다면 해당 줄을 출력합니다.
				if (line.indexOf(";") != -1)
					System.out.println(i + ":" + line);
			}

			// BufferedReader를 닫습니다.
			br.close();
		} catch (IOException e) {
			// 입출력 예외가 발생할 경우 아무 동작도 수행하지 않습니다.
			// (원래는 에러를 출력하거나 예외 처리를 해야하지만, 여기서는 간단하게 무시합니다.)
		}
	} // main
}
