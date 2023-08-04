package example;

class A2 {
    // 클래스 A2의 autoPlay 메서드는 I 인터페이스를 구현한 객체를 매개변수로 받아서 play 메서드를 호출합니다.
    void autoPlay(I i) {
        i.play();
    }
}

interface I {
    // 인터페이스 I는 play 메서드를 선언합니다. 구현은 하지 않고 추상 메서드로 정의합니다.
    public abstract void play();
}

class B2 implements I {
    // 클래스 B2는 I 인터페이스를 구현하여 play 메서드를 오버라이딩합니다.
    public void play() {
        System.out.println("play in B class");
    }
}

class C2 implements I {
    // 클래스 C2는 I 인터페이스를 구현하여 play 메서드를 오버라이딩합니다.
    public void play() {
        System.out.println("play in C class");
    }
}

class InterfaceTest2 {
    public static void main(String[] args) {
        A2 a = new A2(); // A2 클래스의 객체 a를 생성합니다.
        a.autoPlay(new B2()); // a의 autoPlay 메서드에 B2 클래스의 객체를 전달하여 호출합니다.
        a.autoPlay(new C2()); // a의 autoPlay 메서드에 C2 클래스의 객체를 전달하여 호출합니다.
    }
}

