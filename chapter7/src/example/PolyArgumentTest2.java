package example;

class Product2 {
    int price;       // 제품의 가격
    int bonusPoint;  // 제품 구매 시 적립되는 보너스 포인트

    Product2(int price) {
        this.price = price;
        bonusPoint = (int) (price / 10.0); // 보너스 포인트는 제품 가격의 10%로 설정
    }

    Product2() {
        // 기본 생성자 - 가격과 보너스 포인트를 초기화하지 않는 경우 사용
    }
}

class Tv4 extends Product2 {
    Tv4() {
        // 상위 클래스의 생성자 Product2(int price)를 호출하여 price를 100으로 초기화
        super(100); // Tv의 가격을 100으로 설정
    }

    public String toString() {
        // Object 클래스의 toString() 메서드를 재정의하여 "Tv"를 반환하도록 설정
        return "Tv";
    }
}

class Computer2 extends Product2 {
    Computer2() {
        // 상위 클래스의 생성자 Product2(int price)를 호출하여 price를 200으로 초기화
        super(200);
    }

    public String toString() {
        // Object 클래스의 toString() 메서드를 재정의하여 "Computer"를 반환하도록 설정
        return "Computer";
    }
}

class Audio extends Product2 {
    Audio() {
        // 상위 클래스의 생성자 Product2(int price)를 호출하여 price를 50으로 초기화
        super(50);
    }

    public String toString() {
        // Object 클래스의 toString() 메서드를 재정의하여 "Audio"를 반환하도록 설정
        return "Audio";
    }
}

class Buyer2 {
    int money = 1000;           // 소유한 돈의 금액
    int bonusPoint = 0;        // 보너스 포인트
    Product2[] item = new Product2[10]; // 구매한 제품을 저장할 배열
    int i = 0;                 // Product2 배열의 현재 인덱스

    void buy(Product2 p) {
        if (money < p.price) {
            // 보유한 돈이 제품 가격보다 적을 경우, 구매할 수 없음
            System.out.println("잔액이 부족하여 " + p + "을/를 구매할 수 없습니다.");
            return;
        }

        money -= p.price;               // 돈에서 제품 가격만큼 차감하여 결제
        bonusPoint += p.bonusPoint;     // 제품의 보너스 포인트를 누적하여 추가
        item[i++] = p;                  // 구매한 제품을 item 배열에 저장
        System.out.println(p + "을/를 구매하였습니다.");
    }

    void summary() {
        int sum = 0;                   // 구매한 제품들의 총 가격을 저장할 변수
        String itemList = "";          // 구매한 제품들의 목록을 저장할 문자열

        // 배열 item을 순회하며 구매한 제품들의 가격을 합산하고 목록을 만듦
        for (int i = 0; i < item.length; i++) {
            if (item[i] == null) break; // 배열의 끝에 도달하면 종료
            sum += item[i].price;
            itemList += item[i] + ", ";
        }
        System.out.println("총 구매 금액은 " + sum + "원입니다.");
        System.out.println("구매한 제품 목록은 " + itemList + "입니다.");
    }
}

class PolyArgumentTest2 {
    public static void main(String args[]) {
        Buyer2 b = new Buyer2(); // 구매자 객체 생성

        // Buyer2 클래스의 buy(Product2 p) 메서드를 호출하여 다양한 제품을 구매
        b.buy(new Tv4()); // Tv4 객체를 매개변수로 전달하여 Tv4 제품 구매
        b.buy(new Computer2()); // Computer2 객체를 매개변수로 전달하여 Computer2 제품 구매
        b.buy(new Audio()); // Audio 객체를 매개변수로 전달하여 Audio 제품 구매

        b.summary(); // 구매한 제품들의 총 가격과 목록 출력
    }
}

