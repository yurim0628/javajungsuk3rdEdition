package example;

import java.io.*;

class FileSplit {
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("USAGE : java FileSplit filename SIZE_KB");
			System.exit(0); // 프로그램을 종료합니다.
		}

		final int VOLUME = Integer.parseInt(args[1]) * 1000; // 분할 크기를 지정합니다. (KB 단위로 입력된 값)

		try {
			String filename = args[0]; // 분할할 파일의 이름을 저장합니다.

			FileInputStream fis = new FileInputStream(filename); // FileInputStream 객체를 생성합니다.
			BufferedInputStream bis = new BufferedInputStream(fis);

			FileOutputStream fos = null;
			BufferedOutputStream bos = null;

			int data = 0;
			int i = 0;
			int number = 0;

			while ((data = bis.read()) != -1) { // 파일을 읽어서 지정된 크기로 분할하여 저장합니다.
				if (i % VOLUME == 0) { // 지정된 크기만큼 데이터를 읽었을 때, 새로운 파일에 쓰기 작업을 수행합니다.
					if (i != 0) { // 첫 번째 파일을 생성할 때는 close() 메서드를 호출할 필요가 없습니다.
						bos.close();
					}

					fos = new FileOutputStream(filename + "_." + ++number); // 새로운 분할 파일을 생성합니다.
					bos = new BufferedOutputStream(fos);
				}
				bos.write(data); // 분할된 파일에 데이터를 쓰는 작업을 수행합니다.
				i++;
			}

			bis.close();
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} // end of try-catch
	} // end of main
} // end of class FileSplit
