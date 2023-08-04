package exercise;

/* Exercise 7-5. 다음의 코드는 컴파일하면 에러가 발생한다.
 * 그 이유를 설명하고 에러를 수정하기 위해서는 코드를 어떻게 바꾸어야 하는지 변경해보라. */

class Product {
    int price;			// 제품의 가격
    int bonusPoint;		// 제품 구매 시 제공하는 보너스 점수

    Product(int price) {
        this.price = price;
        bonusPoint = price/10;
    }
}

class Tv extends Product {
    //	Tv() {}				/* [답] 컴파일 에러 발생하는 부분 */

    /* Tv 클래스가 Product 클래스를 상속받았지만, Product 클래스에 기본 생성자가 없기 때문이다. */
    /* 기본 생성자는 클래스에 생성자가 하나도 정의되지 않은 경우, 자동으로 컴파일러에 의해 추가되며, 명시적으로 생성자를 선언하지 않을 때만 생성된다. */
    /* 그러나 Product 클래스에는 매개변수를 받는 생성자 Product(int price)만 정의되어 있으므로, 기본 생성자가 자동으로 생성되지 않는다. */
    /* 따라서 Tv 클래스의 기본 생성자에서 super()를 호출하는데, Product 클래스에 기본 생성자가 없으므로 에러가 발생한다. */

    /* 1.Product 클래스에 기본 생성자를 추가한다. */
    /* 2.Tv 클래스의 기본 생성자에서 super(int price)를 호출하도록 수정한다.*/

    Tv() { super(100); }

    public String toString() {
        return "Tv";
    }
}

class Exercise7_5 {
    public static void main(String[] args) {
        Tv t = new Tv();
    }
}