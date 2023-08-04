package example;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

class FileEx5 {
	public static void main(String[] args) {
		if (args.length != 1 || args[0].length() != 1 || "tTlLnN".indexOf(args[0]) == -1) {
			System.out.println("USAGE : java FileEx5 SORT_OPTION");
			System.out.println("   SORT_OPTION :");
			System.out.println("   t     Time ascending sort.");
			System.out.println("   T     Time descending sort.");
			System.out.println("   l     Length ascending sort.");
			System.out.println("   L     Length descending sort.");
			System.out.println("   n     Name ascending sort.");
			System.out.println("   N     Name descending sort.");
			System.exit(0);
		}

		final char option = args[0].charAt(0); // 정렬 옵션을 문자로 저장합니다.

		String currDir = System.getProperty("user.dir"); // 현재 작업 디렉토리의 경로를 얻어옵니다.
		File dir = new File(currDir); // 현재 작업 디렉토리를 나타내는 File 객체를 생성합니다.
		File[] files = dir.listFiles(); // 디렉토리의 파일과 디렉토리 목록을 배열로 얻어옵니다.

		// Comparator 객체를 생성합니다.
		Comparator<File> comp = new Comparator<File>() {
			public int compare(File o1, File o2) {
				long time1 = o1.lastModified();
				long time2 = o2.lastModified();

				long length1 = o1.length();
				long length2 = o2.length();

				String name1 = o1.getName().toLowerCase();
				String name2 = o2.getName().toLowerCase();

				int result = 0;

				switch (option) {
					case 't':
						if (time1 - time2 > 0) result = 1;
						else if (time1 - time2 == 0) result = 0;
						else if (time1 - time2 < 0) result = -1;
						break;
					case 'T':
						if (time1 - time2 > 0) result = -1;
						else if (time1 - time2 == 0) result = 0;
						else if (time1 - time2 < 0) result = 1;
						break;
					case 'l':
						if (length1 - length2 > 0) result = 1;
						else if (length1 - length2 == 0) result = 0;
						else if (length1 - length2 < 0) result = -1;
						break;
					case 'L':
						if (length1 - length2 > 0) result = -1;
						else if (length1 - length2 == 0) result = 0;
						else if (length1 - length2 < 0) result = 1;
						break;
					case 'n':
						result = name1.compareTo(name2);
						break;
					case 'N':
						result = name2.compareTo(name1);
						break;
				}
				return result;
			} // compare

			public boolean equals(Object o) {
				return false;
			} // not used.
		}; // end of Comparator

		Arrays.sort(files, comp); // 파일과 디렉토리 목록을 정렬합니다.

		for (int i = 0; i < files.length; i++) { // 정렬된 배열의 각 요소에 대해 반복하면서
			File f = files[i]; // 현재 요소를 File 객체로 가져옵니다.
			String name = f.getName(); // 파일 또는 디렉토리 이름을 가져옵니다.
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // 날짜 포맷을 설정합니다.
			String attribute = ""; // 파일 속성을 저장할 변수입니다.
			String size = ""; // 파일 크기를 저장할 변수입니다.

			if (f.isDirectory()) { // 해당 요소가 디렉토리인 경우
				attribute = "DIR"; // 속성을 "DIR"로 설정합니다.
			} else { // 해당 요소가 파일인 경우
				size = f.length() + ""; // 파일 크기를 문자열로 변환하여 저장합니다.
				attribute = f.canRead() ? "R" : " "; // 읽기 가능 여부를 "R" 또는 공백으로 표시합니다.
				attribute += f.canWrite() ? "W" : " "; // 쓰기 가능 여부를 "W" 또는 공백으로 표시합니다.
				attribute += f.isHidden() ? "H" : " "; // 숨김 여부를 "H" 또는 공백으로 표시합니다.
			}

			System.out.printf("%s %3s %6s %s%n", df.format(new Date(f.lastModified())), attribute, size, name);
			// 수정일시, 속성, 크기, 이름을 출력합니다.
		} // for
	} // main
} // end of class
