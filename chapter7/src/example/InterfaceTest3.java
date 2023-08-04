package example;

class InterfaceTest3 {
    public static void main(String[] args) {
        A3 a = new A3(); // A3 클래스의 객체 a를 생성합니다.
        a.methodA(); // a의 methodA 메서드를 호출합니다.
    }
}

class A3 {
    void methodA() {
        I3 i = InstanceManager.getInstance(); // I3 인터페이스를 구현한 객체를 얻어옵니다.
        i.methodB(); // i의 methodB 메서드를 호출합니다.
        System.out.println(i.toString()); // i 객체의 toString 메서드를 호출하여 출력합니다. (Object 클래스의 메서드)
    }
}

interface I3 {
    public abstract void methodB(); // 인터페이스 I3는 methodB 메서드를 선언합니다. 구현은 하지 않고 추상 메서드로만 정의합니다.
}

class B3 implements I3 {
    public void methodB() {
        System.out.println("methodB in B3 class"); // 클래스 B3는 I3 인터페이스를 구현하여 methodB 메서드를 오버라이딩합니다.
    }

    public String toString() {
        return "class B3"; // toString 메서드를 오버라이딩하여 "class B3" 문자열을 반환합니다.
    }
}

class InstanceManager {
    public static I3 getInstance() {
        return new B3(); // B3 클래스의 객체를 반환하는 getInstance 메서드를 정적(static)으로 구현합니다.
    }
}

