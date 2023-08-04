package example;

import java.io.*;

class FileConversion {
	public static void main(String args[]) {
		try {
			FileReader fr = new FileReader(args[0]); // 입력 파일로부터 데이터를 읽기 위한 FileReader 객체를 생성합니다.
			FileWriter fw = new FileWriter(args[1]); // 출력 파일에 데이터를 쓰기 위한 FileWriter 객체를 생성합니다.

			int data = 0;
			while ((data = fr.read()) != -1) {
				// 읽어온 데이터가 탭(\t), 개행(\n), 공백(' '), 복귀(\r)가 아닌 경우에만 출력 파일에 쓰도록 합니다.
				if (data != '\t' && data != '\n' && data != ' ' && data != '\r')
					fw.write(data);
			}

			fr.close(); // 입력 파일을 닫습니다.
			fw.close(); // 출력 파일을 닫습니다.
		} catch (IOException e) {
			// 입출력 예외가 발생할 경우 해당 예외를 출력합니다.
			e.printStackTrace();
		}
	} // main
}
