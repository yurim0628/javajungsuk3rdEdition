package exercise;

import java.util.*;

class Exercise11_10 {
	public static void main(String[] args) {
		Set set = new HashSet(); // 중복을 허용하지 않는 Set 인터페이스를 구현한 HashSet 객체를 생성합니다.
		int[][] board = new int[5][5]; // 5x5 크기의 이차원 배열 board를 생성합니다.

		// 1부터 30까지의 난수를 생성하여 Set에 추가합니다.
		// Set은 중복된 요소를 허용하지 않기 때문에 난수를 25개만 추가될 때까지 반복합니다.
		for (int i = 0; set.size() < 25; i++) {
			set.add((int)(Math.random() * 30) + 1 + ""); // 난수를 문자열로 변환하여 Set에 추가합니다.
		}

		ArrayList list = new ArrayList(set); // Set을 ArrayList로 변환합니다.
		Collections.shuffle(list); // ArrayList의 요소들을 무작위로 섞습니다.
		Iterator it = list.iterator(); // Iterator를 사용하여 ArrayList의 요소들을 차례로 접근합니다.

		// 섞인 요소들을 5x5 크기의 이차원 배열 board에 저장하고 출력합니다.
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = Integer.parseInt((String) it.next()); // ArrayList에서 가져온 값을 정수로 변환하여 배열에 저장합니다.
				System.out.print((board[i][j] < 10 ? " " : " ") + board[i][j]); // 한 자리 숫자는 앞에 공백을 붙여 출력합니다.
			}
			System.out.println(); // 한 행의 출력이 끝나면 줄바꿈을 해서 다음 행을 출력합니다.
		}
	}
}