package exercise;

import java.util.*;

class Student implements Comparable { // Comparable 인터페이스를 구현하도록 변경
	String name;
	int ban;
	int no;
	int kor, eng, math;

	// Student 생성자
	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	// 총점 계산 메서드
	int getTotal() {
		return kor + eng + math;
	}

	// 평균 계산 메서드
	float getAverage() {
		return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
	}

	// 객체 정보를 문자열로 반환하는 메서드
	public String toString() {
		return name + ", " + ban + ", " + no + ", " + kor + ", " + eng + ", " + math + ", " + getTotal() + ", " + getAverage();
	}

	// Comparable 인터페이스의 compareTo 메서드 구현
	// 이름(name)을 기준으로 정렬하기 위해 compareTo를 오버라이드합니다.
	public int compareTo(Object o) {
		if (o instanceof Student) {
			Student tmp = (Student) o;
			return name.compareTo(tmp.name); // 이름(name)을 비교하여 정렬합니다.
		} else {
			return -1;
		}
	}
}

class Exercise11_5 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student("홍길동", 1, 1, 100, 100, 100));
		list.add(new Student("남궁성", 1, 2, 90, 70, 80));
		list.add(new Student("김자바", 1, 3, 80, 80, 90));
		list.add(new Student("이자바", 1, 4, 70, 90, 70));
		list.add(new Student("안자바", 1, 5, 60, 100, 80));

		Collections.sort(list); // list에 저장된 요소들을 이름(name) 기준으로 정렬합니다.
		Iterator it = list.iterator();

		while (it.hasNext())
			System.out.println(it.next());
	}
}
