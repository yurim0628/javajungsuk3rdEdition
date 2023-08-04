package example;

class DefaultMethodTest {
    public static void main(String[] args) {
        Child c = new Child();
        c.method1();  // Child 클래스에서 method1()을 재정의하였으므로, Child 클래스의 method1()이 호출됩니다.
        c.method2();  // Child 클래스에서 method2()를 정의하지 않았으므로, Parent 클래스의 method2()가 상속되어 호출됩니다.
        MyInterface.staticMethod();    // MyInterface에 정의된 정적 메서드 staticMethod()를 인터페이스 이름으로 직접 호출합니다.
        MyInterface2.staticMethod();   // MyInterface2에 정의된 정적 메서드 staticMethod()를 인터페이스 이름으로 직접 호출합니다.
    }
}

class Child extends Parent implements MyInterface, MyInterface2 {
    public void method1() {
        System.out.println("method1() in Child"); // Child 클래스에서 method1()을 재정의(오버라이딩)하였습니다.
    }
}

class Parent {
    public void method2() {
        System.out.println("method2() in Parent"); // Parent 클래스에서 method2()를 정의하였습니다.
    }
}

interface MyInterface {
    default void method1() {
        System.out.println("method1() in MyInterface"); // MyInterface에 정의된 기본 메서드 method1()입니다.
    }

    default void method2() {
        System.out.println("method2() in MyInterface"); // MyInterface에 정의된 기본 메서드 method2()입니다.
    }

    static void staticMethod() {
        System.out.println("staticMethod() in MyInterface"); // MyInterface에 정의된 정적 메서드 staticMethod()입니다.
    }
}

interface MyInterface2 {
    default void method1() {
        System.out.println("method1() in MyInterface2"); // MyInterface2에 정의된 기본 메서드 method1()입니다.
    }

    static void staticMethod() {
        System.out.println("staticMethod() in MyInterface2"); // MyInterface2에 정의된 정적 메서드 staticMethod()입니다.
    }
}

