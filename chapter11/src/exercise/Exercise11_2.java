package exercise;

import java.util.*;

class Exercise11_2 {
	public static void main(String[] args) {
		// 정수를 저장하기 위한 ArrayList 'list'를 생성합니다.
		ArrayList list = new ArrayList();

		// 'list'에 정수를 추가합니다.
		list.add(3);
		list.add(6);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(7);

		// 'list'의 내용을 출력합니다.
		System.out.println("list : " + list);

		// HashSet인 'set'을 생성하고, 'list'의 요소들로 초기화합니다.
		// HashSet을 사용하여 중복된 요소들을 제거합니다.
		HashSet set = new HashSet(list);

		// 'set'의 내용을 출력합니다. 중복이 제거된 상태로 출력됩니다.
		System.out.println("set : " + set);

		// TreeSet인 'tset'을 생성하고, 'set'의 요소들로 초기화합니다.
		// TreeSet은 요소들을 자동으로 오름차순으로 정렬합니다.
		TreeSet tset = new TreeSet(set);

		// 'tset'의 내용을 출력합니다. 정렬된 상태로 출력됩니다.
		System.out.println("tset : " + tset);

		// 정수를 저장하기 위한 Stack 'stack'을 생성합니다.
		Stack stack = new Stack();

		// 'tset'의 모든 요소들을 'stack'에 추가합니다.
		stack.addAll(tset);

		// 'stack'이 비어있지 않은 동안, 요소들을 역순으로 출력하고 제거합니다.
		while (!stack.empty())
			System.out.println(stack.pop());
	}
}
