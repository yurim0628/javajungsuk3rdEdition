package exercise;

import java.util.*;

class Student {
	String name;
	int ban;
	int no;
	int kor, eng, math;

	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	int getTotal() {
		return kor+eng+math;
	}

	float getAverage() {
		return (int)((getTotal() / 3f)*10 + 0.5)/10f;
	}

	public String toString() {
		return name + ", " + ban + ", " + no + ", " + kor + ", " + eng + ", " + math + ", " + getTotal() + ", " + getAverage();
	}

}

class BanNoAscending implements Comparator {
	public int compare(Object o1, Object o2) {
		/* 알맞은 코드를 넣어 완성하시오. */
		// o1과 o2가 Student 클래스의 객체인지 확인합니다.
		if (o1 instanceof Student && o2 instanceof Student) {
			// o1과 o2를 Student 클래스로 형변환하여 사용합니다.
			Student s1 = (Student) o1;
			Student s2 = (Student) o2;

			// 먼저 반(ban)을 기준으로 오름차순 정렬을 수행합니다.
			int result = s1.ban - s2.ban;

			// 만약 반이 동일한 경우, 학생 번호(no)를 기준으로 오름차순 정렬을 수행합니다.
			if (result == 0) {
				return s1.no - s2.no;
			}

			return result; // 반 또는 번호가 다른 경우, 결과를 반환합니다.
		} else {
			// o1 또는 o2가 Student 클래스의 객체가 아닌 경우, 비교가 불가능하므로 -1을 반환합니다.
			return -1;
		}
	}
}

class Exercise11_7 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student("이자바", 2, 1, 70, 90, 70));
		list.add(new Student("안자바", 2, 2, 60, 100, 80));
		list.add(new Student("홍길동", 1, 3, 100, 100, 100));
		list.add(new Student("남궁성", 1, 1, 90, 70, 80));
		list.add(new Student("김자바", 1, 2, 80, 80, 90));

		Collections.sort(list, new BanNoAscending());
		Iterator it = list.iterator();

		while(it.hasNext())
			System.out.println(it.next());
	}
}