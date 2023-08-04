package exercise;

/* Exercise 7-2. 문제 7-1의 SutdaDeck클래스에 다음에 정의된 새로운 메서드를 추가하고 테스트하시오.
 * [주의] Math.random()을 사용하는 경우 실행결과와 다를 수 있음
 * 1. 	메서드명	: shuffle
 * 		기능		: 배열 cards에 담긴 카드의 위치를 뒤섞는다. (Math.random() 사용)
 *		반환타입	: 없음
 *		매개변수	: 없음
 * 2. 	메서드명	: pick
 * 		기능		: 배열 cards에서 지정된 위치의 SutdaCard를 반환한다.
 *		반환타입	: SutdaCard
 *		매개변수	: int index - 위치
 * 3. 	메서드명	: pick
 * 		기능		: 배열 cards에서 임의의 위치의 SutdaCard를 반환한다. (Math.random() 사용)
 *		반환타입	: SutdaCard
 *		매개변수	: 없음
 */

class SutdaDeck2 {
    final int CARD_NUM = 20;
    SutdaCard[] cards = new SutdaCard[CARD_NUM];

    SutdaDeck2() {
        // SutdaCard 배열에 20개의 카드를 생성하여 초기화한다.
        for (int i = 0; i < cards.length; i++) {
            int num = i % 10 + 1;   // 카드 번호는 1부터 10까지 순차적으로 증가한다.
            boolean isKwang = (i < 10) && (num == 1 || num == 3 || num == 8);
            // isKwang 변수는 인덱스가 0부터 9인 카드 중 번호가 1, 3, 8인 경우 true로 설정된다.
            cards[i] = new SutdaCard(num, isKwang);
            // SutdaCard 클래스의 객체를 생성하여 cards 배열에 저장한다.
        }
    }

    public void shuffle() {
        // 카드를 무작위로 섞는 메서드이다.
        for (int i = 0; i < cards.length; i++) {
            int j = (int) (Math.random() * cards.length);
            SutdaCard temp = cards[j];
            cards[j] = cards[i];
            cards[i] = temp;
        }
    }

    public SutdaCard pick(int index) {
        // 주어진 인덱스에 해당하는 카드를 반환한다.
        if (index < 0 || index >= CARD_NUM) return null;
        return cards[index];
    }

    public SutdaCard pick() {
        // 무작위로 카드를 한 장 선택하여 반환한다.
        int index = (int) (Math.random() * cards.length);
        return pick(index);
    }
}

class SutdaCard2 {
    int num;        // 카드의 번호를 나타내는 변수이다.
    boolean isKwang;    // 광(홍단, 초단, 청단) 여부를 나타내는 변수이다.

    SutdaCard2() {
        this(1, true);
        // 기본 생성자는 번호 1과 광(true) 값을 가진 카드로 초기화되며, 다른 생성자를 호출하여 초기화한다.
    }

    SutdaCard2(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
        // 매개변수를 받아 해당 값으로 카드를 초기화하는 생성자이다.
    }

    // info() 대신 Object 클래스의 toString()을 오버라이딩한다.
    public String toString() {
        return num + (isKwang ? "K" : "");
        // 카드의 번호와 광 여부를 문자열로 반환하는 메서드이다.
    }
}

class Exercise7_2 {
    public static void main(String args[]) {
        SutdaDeck2 deck = new SutdaDeck2();

        System.out.println(deck.pick(0));   // 인덱스 0번 카드 출력
        System.out.println(deck.pick());    // 무작위로 선택한 카드 출력
        deck.shuffle();                     // 카드 섞기

        // 섞은 카드 출력
        for (int i = 0; i < deck.cards.length; i++)
            System.out.print(deck.cards[i] + ",");

        System.out.println();
        System.out.println(deck.pick(0));   // 인덱스 0번 카드 출력
    }
}
