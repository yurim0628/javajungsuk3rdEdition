package exercise;

import java.util.*;

class Student implements Comparable {
	String name;
	int ban;
	int no;
	int kor, eng, math;

	int total;
	int schoolRank;

	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;

		total = kor+eng+math;
	}

	int getTotal() {
		return total;
	}

	float getAverage() {
		return (int)((getTotal() / 3f)*10 + 0.5)/10f;
	}

	public String toString() {
		return name + ", " + ban + ", " + no + ", " + kor + ", " + eng + ", " + math + ", " + getTotal() + ", " + getAverage() + ", " + schoolRank;
	}

	public int compareTo(Object o) {
		/* (1) 알맞은 코드를 넣어 완성하시오. */
		if (o instanceof Student) {
			Student tmp = (Student) o;

			// 비교 대상의 총점(tmp.total)과 현재 학생의 총점(this.total)을 비교하여 결과 반환
			// 큰 총점이 먼저 오도록 정렬하기 위해 현재 학생의 총점에서 비교 대상의 총점을 뺀 값을 반환
			return tmp.total - this.total;
		} else {
			// 비교 대상이 Student 객체가 아닌 경우 -1을 반환하여
			// 정렬에서 우선순위를 가장 낮게 설정합니다.
			return -1;
		}
	}
}

class Exercise11_8 {
	public static void calculateSchoolRank(List list) {
		Collections.sort(list);

		int prevRank	= -1;
		int prevTotal	= -1;
		int length = list.size();

		/* (2) 알맞은 코드를 넣어 완성하시오. */
		// 학생 객체 리스트에서 전교등수(schoolRank)를 계산하여 설정하는 부분입니다.
		for (int i = 0; i < length; i++) {
			// 리스트에서 i번째 학생 객체를 가져옵니다.
			Student s = (Student) list.get(i);

			// 이전 학생의 총점(prevTotal)과 현재 학생의 총점이 같으면,
			// 이전 학생과 동일한 전교등수를 가집니다.
			if (s.total == prevTotal) {
				s.schoolRank = prevRank;
			} else {
				// 이전 학생과 총점이 다른 경우, i + 1 값을 전교등수로 설정합니다.
				// 이는 i가 0부터 시작하므로 등수는 1부터 시작하는 것과 같습니다.
				s.schoolRank = i + 1;
			}

			// 이전 학생의 전교등수(prevRank)와 총점(prevTotal)을 현재 학생의 값으로 업데이트합니다.
			prevRank = s.schoolRank;
			prevTotal = s.total;
		}
	}

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student("이자바", 2, 1, 70, 90, 70));
		list.add(new Student("안자바", 2, 2, 60, 100, 80));
		list.add(new Student("홍길동", 1, 3, 100, 100, 100));
		list.add(new Student("남궁성", 1, 1, 90, 70, 80));
		list.add(new Student("김자바", 1, 2, 80, 80, 90));

		calculateSchoolRank(list);

		Iterator it = list.iterator();

		while(it.hasNext())
			System.out.println(it.next());
	}
}
