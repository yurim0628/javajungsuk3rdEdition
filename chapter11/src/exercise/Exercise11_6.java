package exercise;

import java.util.*;

class Student implements Comparable {
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

	public int compareTo(Object o) {
		if(o instanceof Student) {
			Student tmp = (Student)o;
			return name.compareTo(tmp.name);
		} else {
			return -1;
		}
	}
}

class Exercise11_6 {
	static int getGroupCount(TreeSet tset, int from, int to) {
		/* (1) 알맞은 코드를 넣어 완성하시오. */
		// 해당 범위의 성적 구간(from ~ to)에 속하는 학생 수를 계산하여 반환합니다.
		// TreeSet은 정렬된 Set이므로, from과 to 사이의 성적을 가진 학생들이 subSet에 속하게 됩니다.
		// subSet을 이용하여 범위에 해당하는 학생들을 찾고, size() 메서드를 통해 학생의 수를 반환합니다.
		Student s1 = new Student("", 0, 0, from, from, from);
		Student s2 = new Student("", 0, 0, to, to, to);

		return tset.subSet(s1, s2).size();
	}

	public static void main(String[] args) {
		TreeSet set = new TreeSet(new Comparator() { // TreeSet을 만들 때 Comparator를 구현한 익명 클래스를 사용합니다.
			public int compare(Object o1, Object o2) {
				/* (2) 알맞은 코드를 넣어 완성하시오. */
				// TreeSet을 평균 점수를 기준으로 정렬하기 위해 Comparator를 구현합니다.
				// compare 메서드를 오버라이딩하여, 두 학생 객체의 평균 점수를 비교합니다.
				// 오름차순 정렬을 하기 위해 s1.getAverage() - s2.getAverage()를 반환합니다.
				// 이 때, 반환값이 음수라면 s1이 s2보다 평균 점수가 작다는 의미이며,
				// 반환값이 양수라면 s1이 s2보다 평균 점수가 크다는 의미입니다.
				if (o1 instanceof Student && o2 instanceof Student) {
					Student s1 = (Student) o1;
					Student s2 = (Student) o2;

					return (int) (s1.getAverage() - s2.getAverage());
				}
				return -1;
			}
		});

		set.add(new Student("홍길동", 1, 1, 100, 100, 100));
		set.add(new Student("남궁성", 1, 2, 90, 70, 80));
		set.add(new Student("김자바", 1, 3, 80, 80, 90));
		set.add(new Student("이자바", 1, 4, 70, 90, 70));
		set.add(new Student("안자바", 1, 5, 60, 100, 80));

		Iterator it = set.iterator();

		while(it.hasNext())
			System.out.println(it.next());

		System.out.println("[60~69] : " + getGroupCount(set, 60, 70));
		System.out.println("[70~79] : " + getGroupCount(set, 70, 80));
		System.out.println("[80~89] : " + getGroupCount(set, 80, 90));
		System.out.println("[90~100] : " + getGroupCount(set, 90, 100));

	}
}
