package example;

import java.io.*;
import java.util.stream.*;

class StreamEx2 {
	public static void main(String[] args) {
		// File 배열 생성
		File[] fileArr = {
				new File("Ex1.java"),
				new File("Ex1.bak"),
				new File("Ex2.java"),
				new File("Ex1"),
				new File("Ex1.txt")
		};

		// File 배열로부터 스트림 생성
		Stream<File> fileStream = Stream.of(fileArr);

		// 파일명을 추출하여 출력하는 스트림 생성 및 출력
		Stream<String> filenameStream = fileStream.map(File::getName);
		filenameStream.forEach(System.out::println);  // 모든 파일의 이름을 출력

		// 파일 스트림 다시 생성
		fileStream = Stream.of(fileArr);

		// 파일명에서 확장자를 추출하고 대문자로 변환하여 중복을 제거하고 출력
		fileStream.map(File::getName)                      // Stream<File> -> Stream<String>
				.filter(s -> s.indexOf('.') != -1)       // 확장자가 없는 것은 제외
				.map(s -> s.substring(s.indexOf('.') + 1)) // 확장자만 추출
				.map(String::toUpperCase)                // 모두 대문자로 변환
				.distinct()                               // 중복 제거
				.forEach(System.out::print);             // JAVABAKTXT

		System.out.println();
	}
}
