package exercise;

/* Exercise 7-7. ★ 다음의 코드를 실행했을 때 호출되는 생성자의 순서와 실행결과를 적으시오.
 * [호출되는 생성자의 순서]	Child() - Child(int x) - Parent() - Parent(int x) - Object
 *						호출은 이와 같이 되고, 실제 생성은 역순으로 생성
 * [실행결과]				c.x = 1000,		c.getX() = 200 (부모의 getX() 메서드가 실행됐으므로 부모의 x를 반환)
 */

class Parent {
    int x = 100;

    Parent() {
        this(200); // 2. Parent(int x) 생성자 호출
    }

    Parent(int x) {
        this.x = x; // 4. 전달받은 인자 x로 멤버 변수 x를 초기화
    }

    int getX() {
        return x; // 5. 멤버 변수 x 값을 반환
    }
}

class Child extends Parent {
    int x = 3000;

    Child() {
        this(1000); // 7. Child(int x) 생성자 호출
    }

    Child(int x) {
        this.x = x; // 9. 전달받은 인자 x로 멤버 변수 x를 초기화
    }
}

class Exercise7_7 {
    public static void main(String[] args) {
        Child c = new Child(); // 1. Child 클래스의 객체 c를 생성

        System.out.println("c.x = " + c.x);               // 10. Child 클래스의 멤버 변수 x 출력 (c.x = 1000)
        System.out.println("c.getX() = " + c.getX());    // 11. Parent 클래스의 메서드 getX() 호출, Parent 클래스의 멤버 변수 x 출력 (c.getX() = 200)
    }
}
