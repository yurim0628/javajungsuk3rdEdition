package exercise;

import java.util.*;

class SutdaCard {
	int num;
	boolean isKwang; // 광인지 여부를 나타내는 불리언 변수

	SutdaCard() {
		this(1, true); // 매개변수가 없는 생성자에서 다른 생성자를 호출하여 기본 값을 설정합니다.
	}

	SutdaCard(int num, boolean isKwang) {
		this.num = num; // 숫자와 광인지 여부를 매개변수로 받아 인스턴스 변수에 설정합니다.
		this.isKwang = isKwang;
	}

	public boolean equals(Object obj) {
		// 두 SutdaCard 객체의 num과 isKwang 값이 같으면 true를 반환하는 equals 메서드를 오버라이드합니다.
		if (obj instanceof SutdaCard) {
			SutdaCard c = (SutdaCard) obj;
			return num == c.num && isKwang == c.isKwang;
		} else {
			return false;
		}
	}

	public String toString() {
		// SutdaCard 객체를 문자열로 표현하는 toString 메서드를 오버라이드합니다.
		// 예를 들어, num이 3이고 isKwang이 true인 경우 "3K"를 반환하고, isKwang이 false인 경우 "3"을 반환합니다.
		return num + (isKwang ? "K" : "");
	}

	public int hashCode() {
		// SutdaCard 객체의 해시 코드를 계산하는 hashCode 메서드를 오버라이드합니다.
		// toString 메서드를 호출하여 문자열로 변환한 후, 해당 문자열의 해시 코드를 반환합니다.
		return toString().hashCode();
	}
}

class Exercise11_11 {
	public static void main(String[] args) {
		SutdaCard c1 = new SutdaCard(3, true); // SutdaCard 객체를 생성합니다.
		SutdaCard c2 = new SutdaCard(3, true);
		SutdaCard c3 = new SutdaCard(1, true);

		HashSet set = new HashSet(); // HashSet을 생성합니다.
		set.add(c1); // SutdaCard 객체를 HashSet에 추가합니다.
		set.add(c2);
		set.add(c3);

		System.out.println(set); // HashSet에 추가된 SutdaCard 객체들을 출력합니다.
	}
}
