package example;

class BindingTest{
    public static void main(String[] args) {
        Parent3 p = new Child3(); // Example.Parent3 타입의 변수 p에 Example.Child3 클래스의 인스턴스를 대입
        Child3 c = new Child3(); // Example.Child3 클래스의 인스턴스를 생성하여 변수 c에 대입

        System.out.println("p.x = " + p.x); // p의 x 멤버 변수 출력 -> 100
        p.method(); // Example.Parent3 클래스의 method() 호출 -> "Parent Method" 출력

        System.out.println("c.x = " + c.x); // c의 x 멤버 변수 출력 -> 200
        c.method(); // Example.Child3 클래스의 method() 호출 -> "Child Method" 출력
    }
}

class Parent3 {
    int x = 100; // Example.Parent3 클래스의 멤버 변수 x 선언 및 초기화

    void method() { // Example.Parent3 클래스의 메서드 method()
        System.out.println("Parent Method"); // "Parent Method" 출력
    }
}

class Child3 extends Parent3 { // Example.Parent3 클래스를 상속받는 Example.Child3 클래스
    int x = 200; // Example.Child3 클래스의 멤버 변수 x 선언 및 초기화

    void method() { // Example.Child3 클래스의 메서드 method()으로 Example.Parent3 클래스의 method()를 오버라이딩
        System.out.println("Child Method"); // "Child Method" 출력
    }
}
