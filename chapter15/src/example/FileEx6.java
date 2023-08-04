package example;

import java.io.*;

class FileEx6 {
	static int found = 0;

	public static void main(String args[]) {
		if (args.length != 2) {
			System.out.println("USAGE : java FileEx6 DIRECTORY KEYWORD");
			System.exit(0);
		}

		File dir = new File(args[0]);
		String keyword = args[1];

		if (!dir.exists() || !dir.isDirectory()) {
			System.out.println("��ȿ���� ���� ���丮�Դϴ�.");
			System.exit(0);
		}

		try {
			findInFiles(dir, keyword); // 주어진 디렉토리와 키워드로 파일 내에서 키워드 검색 시작
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println();
		System.out.println("�� " + found + "���� ���ο��� '" + keyword + "'��/�� �߰��Ͽ����ϴ�. ");
	} // main

	public static void findInFiles(File dir, String keyword) throws IOException {
		File[] files = dir.listFiles();

		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				findInFiles(files[i], keyword); // 하위 디렉토리가 있으면 재귀적으로 검색
			} else {
				String filename = files[i].getName();
				String extension = filename.substring(filename.lastIndexOf(".") + 1);
				extension = "," + extension + ",";

				if (",java,txt,bak,".indexOf(extension) == -1) continue; // 검색할 파일 확장자 지정

				filename = dir.getAbsolutePath() + File.separator + filename;

				FileReader fr = new FileReader(files[i]);
				BufferedReader br = new BufferedReader(fr);

				String data = "";
				int lineNum = 0;

				while ((data = br.readLine()) != null) {
					lineNum++;
					if (data.indexOf(keyword) != -1) { // 키워드가 파일 내에 발견되면
						found++;
						System.out.println("[" + filename + "(" + lineNum + ")" + "]" + data); // 발견된 위치 출력
					}
				} // while

				br.close();
			}
		} // for
	} // findInFiles
} // class
