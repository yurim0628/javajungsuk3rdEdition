package example;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class FileEx4 {
	public static void main(String[] args) {
		String currDir = System.getProperty("user.dir"); // 현재 작업 디렉토리의 경로를 얻어옵니다.
		File dir = new File(currDir); // 현재 작업 디렉토리를 나타내는 File 객체를 생성합니다.

		File[] files = dir.listFiles(); // 디렉토리의 파일과 디렉토리 목록을 배열로 얻어옵니다.

		for (int i = 0; i < files.length; i++) { // 배열의 각 요소에 대해 반복하면서
			File f = files[i]; // 현재 요소를 File 객체로 가져옵니다.
			String name = f.getName(); // 파일 또는 디렉토리 이름을 가져옵니다.
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mma"); // 날짜 포맷을 설정합니다.
			String attribute = ""; // 파일 속성을 저장할 변수입니다.
			String size = ""; // 파일 크기를 저장할 변수입니다.

			if (files[i].isDirectory()) { // 해당 요소가 디렉토리인 경우
				attribute = "DIR"; // 속성을 "DIR"로 설정합니다.
			} else { // 해당 요소가 파일인 경우
				size = f.length() + ""; // 파일 크기를 문자열로 변환하여 저장합니다.
				attribute = f.canRead() ? "R" : " "; // 읽기 가능 여부를 "R" 또는 공백으로 표시합니다.
				attribute += f.canWrite() ? "W" : " "; // 쓰기 가능 여부를 "W" 또는 공백으로 표시합니다.
				attribute += f.isHidden() ? "H" : " "; // 숨김 여부를 "H" 또는 공백으로 표시합니다.
			}

			System.out.printf("%s %3s %6s %s%n", df.format(new Date(f.lastModified())), attribute, size, name);
			// 수정일시, 속성, 크기, 이름을 출력합니다.
		}
	}
} // end of class
