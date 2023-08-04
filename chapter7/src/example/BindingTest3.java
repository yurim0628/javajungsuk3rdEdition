package example;

class BindingTest3 {
    public static void main(String[] args) {
        Parent5 p = new Child5(); // Parent5 타입의 변수 p에 Child5 클래스의 인스턴스를 대입
        Child5 c = new Child5(); // Child5 클래스의 인스턴스를 생성하여 변수 c에 대입

        System.out.println("p.x = " + p.x); // p의 x 멤버 변수 출력 -> 100
        p.method(); // Parent5 클래스의 method() 호출

        System.out.println();

        System.out.println("c.x = " + c.x); // c의 x 멤버 변수 출력 -> 200
        c.method(); // Child5 클래스의 method() 호출
    }
}

class Parent5 {
    int x = 100; // Parent5 클래스의 멤버 변수 x 선언 및 초기화

    void method() { // Parent5 클래스의 메서드 method()
        System.out.println("Parent Method"); // "Parent Method" 출력
    }
}

class Child5 extends Parent5 {
    int x = 200; // Child5 클래스의 멤버 변수 x 선언 및 초기화

    void method() { // Child5 클래스의 메서드 method()
        System.out.println("x = " + x); // this.x와 같은 의미로 Child5 클래스의 멤버 변수 x 출력 -> 200
        System.out.println("super.x = " + super.x); // 부모 클래스인 Parent5의 멤버 변수 x 출력 -> 100
        System.out.println("this.x = " + this.x); // Child5 클래스의 멤버 변수 x 출력 -> 200
    }
}

