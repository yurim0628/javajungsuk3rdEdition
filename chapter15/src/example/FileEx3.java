package example;

import java.io.*;
import java.util.ArrayList;

class FileEx3 {
	static int totalFiles = 0; // 전체 파일 수를 저장하는 변수
	static int totalDirs = 0; // 전체 디렉토리 수를 저장하는 변수

	public static void main(String[] args) {
		if (args.length != 1) { // 프로그램 실행 시 디렉토리를 인자로 전달하지 않은 경우
			System.out.println("USAGE : java FileEx3 DIRECTORY"); // 사용법을 출력합니다.
			System.exit(0); // 프로그램을 종료합니다.
		}

		File dir = new File(args[0]); // 인자로 전달받은 디렉토리 경로를 File 객체로 생성합니다.

		if (!dir.exists() || !dir.isDirectory()) { // 해당 경로가 존재하지 않거나 디렉토리가 아닌 경우
			System.out.println("유효하지 않은 디렉토리입니다."); // 메시지를 출력합니다.
			System.exit(0); // 프로그램을 종료합니다.
		}

		printFileList(dir); // 디렉토리와 하위 디렉토리의 파일과 디렉토리 목록을 출력하는 메서드를 호출합니다.

		System.out.println();
		System.out.println("총 " + totalFiles + "개의 파일");
		System.out.println("총 " + totalDirs + "개의 디렉토리");
	} // main

	public static void printFileList(File dir) {
		System.out.println(dir.getAbsolutePath() + " 디렉토리"); // 현재 디렉토리 경로를 출력합니다.
		File[] files = dir.listFiles(); // 디렉토리의 파일과 디렉토리 목록을 배열로 얻어옵니다.

		ArrayList<String> subDir = new ArrayList<>(); // 하위 디렉토리의 인덱스를 저장하는 ArrayList를 생성합니다.

		for (int i = 0; i < files.length; i++) { // 배열의 각 요소에 대해 반복하면서
			String filename = files[i].getName();

			if (files[i].isDirectory()) { // 해당 요소가 디렉토리라면
				filename = "[" + filename + "]"; // "[파일이름]" 형식으로 출력합니다.
				subDir.add(i + ""); // 하위 디렉토리의 인덱스를 ArrayList에 추가합니다.
			}
			System.out.println(filename); // 파일 또는 디렉토리 이름을 출력합니다.
		}

		int dirNum = subDir.size(); // 하위 디렉토리의 개수를 계산합니다.
		int fileNum = files.length - dirNum; // 파일의 개수를 계산합니다.

		totalFiles += fileNum; // 파일의 개수를 전체 파일 수에 더합니다.
		totalDirs += dirNum; // 디렉토리의 개수를 전체 디렉토리 수에 더합니다.

		System.out.println(fileNum + "개의 파일, " + dirNum + "개의 디렉토리");
		System.out.println();

		for (int i = 0; i < subDir.size(); i++) { // 하위 디렉토리의 인덱스를 반복하면서
			int index = Integer.parseInt(subDir.get(i)); // ArrayList에 저장된 인덱스 값을 가져옵니다.
			printFileList(files[index]); // 해당 인덱스에 해당하는 디렉토리를 재귀적으로 출력합니다.
		}
	} // printFileList
}
