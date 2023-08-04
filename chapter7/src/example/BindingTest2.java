package example;
class BindingTest2 {
    public static void main(String[] args) {
        Parent4 p = new Child4(); // Parent4 타입의 변수 p에 Child4 클래스의 인스턴스를 대입
        Child4 c = new Child4(); // Child4 클래스의 인스턴스를 생성하여 변수 c에 대입

        System.out.println("p.x = " + p.x); // p의 x 멤버 변수 출력 -> 100
        p.method(); // Parent4 클래스의 method() 호출 -> "Parent Method" 출력

        System.out.println("c.x = " + c.x); // c의 x 멤버 변수 출력 -> 100
        c.method(); // Child4 클래스의 method() 호출 -> "Parent Method" 출력
    }
}

class Parent4 {
    int x = 100; // Parent4 클래스의 멤버 변수 x 선언 및 초기화

    void method() { // Parent4 클래스의 메서드 method()
        System.out.println("Parent Method"); // "Parent Method" 출력
    }
}

class Child4 extends Parent4 { } // Parent4 클래스를 상속받는 Child4 클래스

