package exercise;

/* Exercise 7-1. 섯다카드 20장을 포함하는 섯다카드 한 벌(SutdaDeck 클래스)을 정의한 것이다.
 * 섯다카드 20장을 담는 ShutdaCard 배열을 초기화하시오.
 * 단, 섯다카드는 1부터 10까지의 숫자가 적힌 카드가 한 쌍씩 있고,
 * 숫자가 1, 3, 8인 경우에는 둘 중의 한 장은 광(Kwang)이어야 한다.
 * 즉, ShutdaCard의 인스턴스변수 isKwang의 값이 true이어야 한다. */

class SutdaDeck {
    final int CARD_NUM = 20;
    SutdaCard[] cards = new SutdaCard[CARD_NUM];

    SutdaDeck() {
        // SutdaCard 배열에 20개의 카드를 생성하여 초기화한다.
        for (int i = 0; i < cards.length; i++) {
            int num = i % 10 + 1;   // 카드 번호는 1부터 10까지 순차적으로 증가한다.
            boolean isKwang = (i < 10) && (num == 1 || num == 3 || num == 8);
            // isKwang 변수는 인덱스가 0부터 9인 카드 중 번호가 1, 3, 8인 경우 true로 설정된다.
            cards[i] = new SutdaCard(num, isKwang);
            // SutdaCard 클래스의 객체를 생성하여 cards 배열에 저장한다.
        }
    }
}

class SutdaCard {
    int num;        // 카드의 번호를 나타내는 변수
    boolean isKwang;    // 광(홍단, 초단, 청단) 여부를 나타내는 변수

    SutdaCard() {
        this(1, true);
        // 기본 생성자는 번호 1과 광(true) 값을 가진 카드로 초기화된다.
    }

    SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
        // 매개변수를 받아 해당 값으로 카드를 초기화하는 생성자이다.
    }

    public String toString() {
        return num + (isKwang ? "K" : "");
        // 카드의 번호와 광 여부를 문자열로 반환하는 메서드이다.
    }
}

class Exercise7_1 {
    public static void main(String args[]) {
        SutdaDeck deck = new SutdaDeck();

        for (int i = 0; i < deck.cards.length; i++)
            System.out.print(deck.cards[i] + ",");
    }
}