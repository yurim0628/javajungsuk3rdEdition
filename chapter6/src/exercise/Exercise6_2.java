package exercise;

class Exercise6_2 {
    public static void main(String args[]) {
        // SutdaCard 클래스의 인스턴스를 생성
        SutdaCard card1 = new SutdaCard(3, false);
        SutdaCard card2 = new SutdaCard();
        System.out.println(card1.info());
        System.out.println(card2.info());
    }
}

class SutdaCard {
    int num;
    boolean isKwang;

    // 생성자 1: 숫자와 광 여부를 인자로 받아 멤버변수를 초기화
    SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    // 생성자 2: 인자 없이 호출되면 num을 1로, isKwang를 true로 초기화
    SutdaCard() {
        this(1, true);
    }

    // 카드 정보를 문자열로 반환하는 메서드
    String info() {
        String result = Integer.toString(num);
        if (isKwang)
            result += "K";
        return result;
    }
}