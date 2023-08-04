package example;

import java.util.*; // Vector 클래스를 사용하기 위해 java.util 패키지를 임포트

// 제품(Product) 클래스
class Product3 {
    int price;          // 제품의 가격
    int bonusPoint;     // 제품 구매 시 적립되는 보너스 포인트

    Product3(int price) {
        this.price = price;
        bonusPoint = (int) (price / 10.0); // 보너스 포인트는 제품 가격의 10%로 설정
    }

    Product3() {
        price = 0;
        bonusPoint = 0;
    }
}

// TV 제품 클래스 (Product 클래스를 상속받음)
class Tv5 extends Product3 {
    Tv5() {
        super(100); // 상위 클래스인 Product3의 생성자를 호출하여 price를 100으로 초기화
    }

    public String toString() {
        return "Tv"; // Object 클래스의 toString() 메서드를 재정의하여 "Tv"를 반환하도록 설정
    }
}

// Computer 제품 클래스 (Product 클래스를 상속받음)
class Computer3 extends Product3 {
    Computer3() {
        super(200); // 상위 클래스인 Product3의 생성자를 호출하여 price를 200으로 초기화
    }

    public String toString() {
        return "Computer"; // Object 클래스의 toString() 메서드를 재정의하여 "Computer"를 반환하도록 설정
    }
}

// Audio 제품 클래스 (Product 클래스를 상속받음)
class Audio3 extends Product3 {
    Audio3() {
        super(50); // 상위 클래스인 Product3의 생성자를 호출하여 price를 50으로 초기화
    }

    public String toString() {
        return "Audio"; // Object 클래스의 toString() 메서드를 재정의하여 "Audio"를 반환하도록 설정
    }
}

// Buyer 클래스 (구매자 클래스)
class Buyer3 {
    int money = 1000;       // 소유한 돈의 금액
    int bonusPoint = 0;     // 보너스 포인트
    Vector item = new Vector(); // 구매한 제품들을 저장할 Vector 객체

    void buy(Product3 p) {
        if (money < p.price) {
            // 보유한 돈이 제품 가격보다 적을 경우, 구매할 수 없음
            System.out.println("잔액이 부족하여 " + p + "을/를 구매할 수 없습니다.");
            return;
        }
        money -= p.price;            // 돈에서 제품 가격만큼 차감하여 결제
        bonusPoint += p.bonusPoint;  // 제품의 보너스 포인트를 누적하여 추가
        item.add(p);                 // 구매한 제품을 Vector에 추가
        System.out.println(p + "을/를 구매하였습니다.");
    }

    void refund(Product3 p) {
        if (item.remove(p)) {
            // Vector에서 제품을 제거하고 환불 처리
            money += p.price;
            bonusPoint -= p.bonusPoint;
            System.out.println(p + "을/를 반품하였습니다.");
        } else {
            System.out.println("해당 제품이 구매 목록에 없습니다.");
        }
    }

    void summary() {
        int sum = 0;            // 구매한 제품들의 총 가격을 저장할 변수
        String itemList = "";   // 구매한 제품들의 목록을 저장할 문자열

        if (item.isEmpty()) {
            // Vector가 비어있을 경우, 즉 아무 제품도 구매하지 않았을 경우
            System.out.println("구매한 제품이 없습니다.");
            return;
        }

        // Vector item을 순회하며 구매한 제품들의 가격을 합산하고 목록을 만듦
        for (int i = 0; i < item.size(); i++) {
            Product3 p = (Product3) item.get(i);
            sum += p.price;
            itemList += (i == 0) ? "" + p : ", " + p;
        }
        System.out.println("총 구매 금액은 " + sum + "원입니다.");
        System.out.println("구매한 제품 목록은 " + itemList + "입니다.");
    }
}

class PolyArgumentTest3 {
    public static void main(String args[]) {
        Buyer3 b = new Buyer3(); // 구매자 객체 생성
        Tv5 tv = new Tv5(); // Tv5 객체 생성
        Computer3 com = new Computer3(); // Computer3 객체 생성
        Audio3 audio = new Audio3(); // Audio3 객체 생성

        b.buy(tv); // 구매자가 Tv5 객체를 구매
        b.buy(com); // 구매자가 Computer3 객체를 구매
        b.buy(audio); // 구매자가 Audio3 객체를 구매
        b.summary(); // 구매한 제품들의 총 가격과 목록 출력
        System.out.println();
        b.refund(com); // 구매자가 Computer3 객체를 반품
        b.summary(); // 구매한 제품들의 총 가격과 목록 출력
    }
}

