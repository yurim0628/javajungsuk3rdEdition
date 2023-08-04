package exercise;

import java.util.*;

class Student implements Comparable {
	String name;
	int ban;
	int no;
	int kor, eng, math;

	int total;
	int schoolRank;
	int classRank;

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
		return name + ", " + ban + ", " + no + ", " + kor + ", " + eng + ", " + math + ", " + getTotal() + ", " + getAverage() + ", " + schoolRank + ", " + classRank;
	}

	public int compareTo(Object o) {
		if(o instanceof Student) {
			Student tmp = (Student)o;

			return tmp.total - this.total;
		} else {
			return -1;
		}
	}

}

class ClassTotalComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		/* (1) 알맞은 코드를 넣어 완성하시오. */
		// o1과 o2가 모두 Student 클래스의 인스턴스인 경우에만 실행됩니다.
		if (o1 instanceof Student && o2 instanceof Student) {
			// o1과 o2를 Student 객체로 캐스팅하여 s1과 s2에 저장합니다.
			Student s1 = (Student) o1;
			Student s2 = (Student) o2;

			// 먼저 학생의 반(ban)을 기준으로 오름차순으로 정렬합니다.
			int result = s1.ban - s2.ban;

			// 만약 두 학생의 반이 같다면, 총점(total)을 기준으로 내림차순으로 정렬합니다.
			// 총점이 같은 경우에는 더 높은 등수가 먼저 오도록 합니다.
			if (result == 0) {
				result = s2.total - s1.total;
			}

			// 정렬 결과를 반환합니다.
			// result가 0보다 작다면 s1이 s2보다 앞에 위치하도록 합니다.
			// result가 0이면 두 학생의 반과 총점이 같으므로 순서를 변경하지 않습니다.
			// result가 0보다 크다면 s1이 s2보다 뒤에 위치하도록 합니다.
			return result;
		} else {
			// o1과 o2 중 적어도 하나가 Student 클래스의 인스턴스가 아닌 경우,
			// 즉 비교 대상이 학생 객체가 아닌 경우, 일관성을 위해 -1을 반환합니다.
			// Comparator의 compare 메서드에서는 비교 대상이 서로 같으면 0을, 서로 다르면 0이 아닌 값을 반환해야 합니다.
			// 따라서 비교 대상이 학생 객체가 아닌 경우에도 0이 아닌 값을 반환하기 위해 -1을 사용합니다.
			return -1;
		}
	}
}

class Exercise11_9 {
	public static void calculateClassRank(List list) {
		Collections.sort(list, new ClassTotalComparator());

		int prevBan		= -1;
		int prevRank	= -1;
		int prevTotal	= -1;
		int length		= list.size();

		/* (2) 알맞은 코드를 넣어 완성하시오. */
		// 학생 리스트(list)에 저장된 학생들을 반 별로 정렬하고, 각 반 내에서 총점 순으로 등수를 매기는 과정을 수행합니다.
		for (int i = 0, n = 0; i < length; i++, n++) {
			Student s = (Student) list.get(i);

			// 학생의 반(ban)이 이전 학생의 반과 다른 경우, 반 등수와 총점을 초기화합니다.
			// n 변수를 사용하여 반 내 등수를 매기기 위해 초기화합니다.
			if (s.ban != prevBan) {
				prevRank = -1; // 이전 반의 등수 초기화
				prevTotal = -1; // 이전 반의 총점 초기화
				n = 0; // 반 내 등수를 매기기 위한 변수 n을 0으로 초기화
			}

			// 현재 학생의 총점과 이전 학생의 총점이 같은 경우, 반 등수를 이전 등수로 설정합니다.
			// 이렇게 함으로써 동점자들은 같은 등수가 됩니다.
			if (s.total == prevTotal) {
				s.classRank = prevRank;
			} else {
				// 총점이 다른 경우, n을 이용하여 현재 학생의 반 등수를 매긴 후, n 값도 1 증가시킵니다.
				// 이렇게 하면 반 내에서 총점이 높은 순서대로 등수가 부여됩니다.
				s.classRank = n + 1;
			}

			// 다음 학생을 처리하기 위해 이전 학생의 반(ban), 반 등수(classRank), 총점(total) 값을 갱신합니다.
			prevBan = s.ban;
			prevRank = s.classRank;
			prevTotal = s.total;
		}
	}

	public static void calculateSchoolRank(List list) {
		Collections.sort(list);

		int prevRank	= -1;
		int prevTotal	= -1;
		int length = list.size();

		for (int i=0; i<length; i++) {
			Student s = (Student)list.get(i);

			if(s.total==prevTotal) {
				s.schoolRank = prevRank;
			} else {
				s.schoolRank = i + 1;
			}

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
		calculateClassRank(list);

		Iterator it = list.iterator();

		while(it.hasNext())
			System.out.println(it.next());
	}
}
