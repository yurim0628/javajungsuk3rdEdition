package example;

class Product {
    int price;       // 제품의 가격
    int bonusPoint;  // 제품 구매 시 적립되는 보너스 포인트

    Product(int price) {
        this.price = price;
        bonusPoint = (int) (price / 10.0); // 보너스 포인트는 제품 가격의 10%로 설정
    }
}

class Tv3 extends Product {
    Tv3() {
        // 상위 클래스의 생성자 Product(int price)를 호출하여 price를 100으로 초기화
        super(100); // Tv의 가격을 100으로 설정
    }

    public String toString() {
        // Object 클래스의 toString() 메서드를 재정의하여 "Tv"를 반환하도록 설정
        return "Tv";
    }
}

class Computer extends Product {
    Computer() {
        // 상위 클래스의 생성자 Product(int price)를 호출하여 price를 200으로 초기화
        super(200);
    }

    public String toString() {
        // Object 클래스의 toString() 메서드를 재정의하여 "Computer"를 반환하도록 설정
        return "Computer";
    }
}

class Buyer {
    int money = 1000; // 소유한 돈의 금액
    int bonusPoint = 0; // 보너스 포인트

    void buy(Product p) {
        if (money < p.price) {
            // 보유한 돈이 제품 가격보다 적을 경우, 구매할 수 없음
            System.out.println("잔액이 부족하여 " + p + "을/를 구매할 수 없습니다.");
            return;
        }

        money -= p.price; // 돈에서 제품 가격만큼 차감하여 결제
        bonusPoint += p.bonusPoint; // 제품의 보너스 포인트를 누적하여 추가
        System.out.println(p + "을/를 구매하였습니다.");
    }
}

class PolyArgumentTest {
    public static void main(String args[]) {
        Buyer b = new Buyer(); // 구매자 객체 생성

        // Buyer 클래스의 buy(Product p) 메서드를 호출하여 다양한 제품을 구매
        b.buy(new Tv3()); // Tv3 객체를 매개변수로 전달하여 Tv3 제품 구매
        b.buy(new Computer()); // Computer 객체를 매개변수로 전달하여 Computer 제품 구매

        System.out.println("남은 돈은 " + b.money + "원입니다.");
        System.out.println("총 보너스 포인트는 " + b.bonusPoint + "점입니다.");
    }
}

