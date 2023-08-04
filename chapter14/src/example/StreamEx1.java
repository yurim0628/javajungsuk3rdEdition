package example;

import java.util.*;
import java.util.stream.*;

class StreamEx1 {
	public static void main(String[] args) {
		// Student 객체 스트림 생성
		Stream<Student> studentStream = Stream.of(
				new Student("이자바", 3, 300),
				new Student("김자바", 1, 200),
				new Student("안자바", 2, 100),
				new Student("박자바", 2, 150),
				new Student("소자바", 1, 200),
				new Student("나자바", 3, 290),
				new Student("감자바", 3, 180)
		);

		// 학년 오름차순, 반 오름차순으로 정렬 후 출력
		studentStream.sorted(Comparator.comparing(Student::getBan)
						.thenComparing(Comparator.naturalOrder()))
				.forEach(System.out::println);
	}
}

class Student implements Comparable<Student> {
	String name;
	int ban;
	int totalScore;

	Student(String name, int ban, int totalScore) {
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}

	public String toString() {
		return String.format("[%s, %d, %d]", name, ban, totalScore);
	}

	String getName() {
		return name;
	}

	int getBan() {
		return ban;
	}

	int getTotalScore() {
		return totalScore;
	}

	// 총점 내림차순으로 정렬
	public int compareTo(Student s) {
		return s.totalScore - this.totalScore;
	}
}
