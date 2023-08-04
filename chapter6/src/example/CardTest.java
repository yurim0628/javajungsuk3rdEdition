package example;

class CardTest{
    public static void main(String args[]) {
        System.out.println("Card.width = "  + Card.width);
        System.out.println("Card.height = " + Card.height);

        Card c1 = new Card();
        c1.kind = "Heart";
        c1.number = 7;

        Card c2 = new Card();
        c2.kind = "Spade";
        c2.number = 4;

        System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + ", " + c1.height + ")" );
        System.out.println("c2는 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + ", " + c2.height + ")" );

        System.out.println("c1의 width와 height를 각각 50, 80으로 변경합니다.");
        c1.width = 50;
        c1.height = 80;
        /* Card인스턴스인 c1과 c2는 클래스변수인 width와 height를 공유하기 때문에,
        c1의 width와 height를 변경하면, c2의 width와 heigth값도 바뀐 것과 같은 결과를 얻는다. */
        /* Card.width, c1.width, c2.width는 모두 같은 저장공간을 참조하므로 항상 같은 값을 갖개 된다. */

        System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + ", " + c1.height + ")" );
        System.out.println("c2는 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + ", " + c2.height + ")" );
    /* 인스턴스변수는 인스턴스가 생성될 때 마다 생성되므로 인스턴스마다 각기 다른 값을 유지할 수 있지만,
    클래스 변수는 모든 인스턴스가 하나의 저장곤간을 공유하므로 항상 공통된 값을 갖는다. */
    }
}

class Card {
    String kind ;				// 카드의 무늬 - 인스턴스 변수
    int number;				    // 카드의 숫자 - 인스턴스 변수
    static int width = 100;		// 카드의 폭  - 클래스 변수
    static int height = 250;	// 카드의 높이 - 클래스 변수
}
