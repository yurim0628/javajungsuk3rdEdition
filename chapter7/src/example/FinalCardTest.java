package example;

// Card2 클래스
class Card2 {
    final int NUMBER;        // 상수로 선언한 필드, 생성자에서 초기화하여 변경 불가능
    final String KIND;       // 상수로 선언한 필드, 생성자에서 초기화하여 변경 불가능
    static int width = 100;  // 정적 필드, 모든 Card2 객체가 공유하는 값
    static int height = 250; // 정적 필드, 모든 Card2 객체가 공유하는 값

    // 생성자 - KIND와 NUMBER를 매개변수로 받아 초기화
    Card2(String kind, int num) {
        KIND = kind;
        NUMBER = num;
    }

    // 기본 생성자 - KIND를 "HEART"로, NUMBER를 1로 초기화하는 생성자 호출
    Card2() {
        this("HEART", 1);
    }

    // toString 메서드 오버라이딩 - KIND와 NUMBER를 문자열로 반환
    public String toString() {
        return KIND + " " + NUMBER;
    }
}

// FinalCardTest 클래스
class FinalCardTest {
    public static void main(String args[]) {
        Card2 c = new Card2("HEART", 10); // Card2 객체 생성, KIND="HEART", NUMBER=10
//      c.NUMBER = 5; // 컴파일 에러! final 필드는 값을 변경할 수 없음
        System.out.println(c.KIND);    // "HEART" 출력
        System.out.println(c.NUMBER);  // 10 출력
        System.out.println(c);         // "HEART 10" 출력
    }
}

