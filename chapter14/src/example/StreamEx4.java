package example;

iimport java.util.*;
import java.util.stream.*;

class StreamEx4 {
	public static void main(String[] args) {
		// 문자열 배열 스트림 생성
		Stream<String[]> strArrStrm = Stream.of(
				new String[]{"abc", "def", "jkl"},
				new String[]{"ABC", "GHI", "JKL"}
		);

		// 배열 스트림을 펼쳐서 문자열 스트림으로 변환
		Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);

		// 문자열을 소문자로 변환한 뒤 중복 제거 및 정렬하여 출력
		strStrm.map(String::toLowerCase)
				.distinct()
				.sorted()
				.forEach(System.out::println);
		System.out.println();

		// 문자열 배열을 단어로 분리한 뒤 소문자로 변환하고 중복 제거 및 정렬하여 출력
		String[] lineArr = {
				"Believe or not It is true",
				"Do or do not There is no try",
		};

		Stream<String> lineStream = Arrays.stream(lineArr);
		lineStream.flatMap(line -> Stream.of(line.split(" +")))
				.map(String::toLowerCase)
				.distinct()
				.sorted()
				.forEach(System.out::println);
		System.out.println();

		// 두 개의 문자열 스트림을 생성하고 배열로 변환한 뒤 펼쳐서 문자열 스트림으로 변환하여 출력
		Stream<String> strStrm1 = Stream.of("AAA", "ABC", "bBb", "Dd");
		Stream<String> strStrm2 = Stream.of("bbb", "aaa", "ccc", "dd");

		Stream<Stream<String>> strStrmStrm = Stream.of(strStrm1, strStrm2);
		Stream<String> strStream = strStrmStrm.map(s -> s.toArray(String[]::new))
				.flatMap(Arrays::stream);

		strStream.map(String::toLowerCase)
				.distinct()
				.forEach(System.out::println);
	}
}
