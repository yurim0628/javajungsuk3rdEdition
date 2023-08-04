package example;

class A {
    // 클래스 A의 methodA 메서드는 B 타입의 객체를 매개변수로 받아서 해당 객체의 methodB 메서드를 호출합니다.
    public void methodA(B b) {
        b.methodB();
    }
}

class B {
    // 클래스 B의 methodB 메서드는 "methodB()"라는 메시지를 출력합니다.
    public void methodB() {
        System.out.println("methodB()");
    }
}

class InterfaceTest {
    public static void main(String args[]) {
        A a = new A(); // A 클래스의 객체 a를 생성합니다.
        a.methodA(new B()); // a의 methodA 메서드에 B 클래스의 객체를 전달하여 호출합니다.
    }
}

