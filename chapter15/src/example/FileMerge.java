package example;

import java.io.*;

class FileMerge {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("USAGE : java FileMerge filename");
			System.exit(0); // 프로그램을 종료합니다.
		}

		String mergeFilename = args[0]; // 사용자가 입력한 파일 이름을 저장합니다.

		try {
			// 임시 파일을 생성합니다. 임시 파일은 프로그램이 종료되면 자동으로 삭제됩니다.
			File tempFile = File.createTempFile("~mergetemp", ".tmp");
			tempFile.deleteOnExit();

			FileOutputStream fos = new FileOutputStream(tempFile);
			BufferedOutputStream bos = new BufferedOutputStream(fos);

			BufferedInputStream bis = null;

			int number = 1; // 파일의 번호를 1부터 시작합니다.

			File f = new File(mergeFilename + "_." + number);

			while (f.exists()) { // 파일 이름에 번호가 붙은 파일들을 차례로 읽어와 합칩니다.
				f.setReadOnly(); // 읽기 전용으로 설정하여 파일을 보호합니다.
				bis = new BufferedInputStream(new FileInputStream(f));

				int data = 0;
				while ((data = bis.read()) != -1) {
					bos.write(data); // 파일을 읽어와 임시 파일에 쓰기 작업을 수행합니다.
				}

				bis.close();

				f = new File(mergeFilename + "_." + ++number); // 다음 파일 이름을 생성합니다.
			} // while

			bos.close();

			File oldFile = new File(mergeFilename); // 합친 파일의 이름을 가진 File 객체를 생성합니다.

			if (oldFile.exists())
				oldFile.delete(); // 기존에 존재하는 파일이 있다면 삭제합니다.

			tempFile.renameTo(oldFile); // 임시 파일을 합쳐진 파일로 이름 변경합니다.
		} catch (IOException e) {
			// 예외 처리를 생략하였습니다. (오류가 발생하면 아무 작업도 하지 않습니다.)
		}
	} // main
} // class
