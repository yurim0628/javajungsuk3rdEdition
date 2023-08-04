package example;

import java.io.*;

class InputStreamReaderEx {
	public static void main(String[] args) {
		String line = "";

		try {
			InputStreamReader isr = new InputStreamReader(System.in); // 콘솔로부터 입력받기 위해 InputStreamReader 객체를 생성합니다.
			BufferedReader br = new BufferedReader(isr); // BufferedReader를 사용하여 효율적으로 입력받습니다.

			System.out.println("사용중인 OS의 문자셋 : " + isr.getEncoding()); // 사용중인 운영체제의 문자셋 정보를 출력합니다.

			do {
				System.out.print("문자열을 입력하세요. 종료하려면 q를 입력하세요. >");
				line = br.readLine(); // 사용자로부터 한 줄의 문자열을 입력받습니다.
				System.out.println("입력한 내용 : " + line);
			} while (!line.equalsIgnoreCase("q")); // 입력받은 문자열이 "q"가 아닐 때까지 반복합니다.

//            br.close(); // System.in은 닫지 않아도 됩니다. 프로그램이 종료될 때 자동으로 닫힙니다.
			System.out.println("프로그램을 종료합니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // main
}
