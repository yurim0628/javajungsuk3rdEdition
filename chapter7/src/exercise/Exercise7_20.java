package exercise;

/* Exercise 7-20. 다음의 코드를 실행한 결과를 적으시오. */

class Exercise7_20 {
    public static void main(String args[]) {
        Parent2 p = new Child2();
        Child2 c = new Child2();

        System.out.println("p.x = " + p.x); // p.x = 100
        p.method(); // Child Method (오버라이딩된 자손 클래스의 메서드 호출)

        System.out.println("c.x = " + c.x); // c.x = 200
        c.method(); // Child Method (자손 클래스의 메서드 호출)
    }
}

class Parent2 {
    int x = 100;

    void method() {
        System.out.println("Parent Method");
    }
}

class Child2 extends Parent2 {
    int x = 200;

    void method() {
        System.out.println("Child Method");
    }
}

/* [해설]
 * 조상 클래스에 선언된 멤버 변수와 같은 이름의 인스턴스 변수를 자손 클래스에 중복으로 정의했을 때,
 * 조상 타입의 참조변수로 자손 인스턴스를 참조하는 경우와, 자손 타입의 참조변수로 자손 인스턴스를 참조하는 경우는 서로 다른 결과를 얻는다.
 *
 * (인스턴스)메서드의 경우, 조상 클래스의 메서드를 자손 클래스에서 오버라이딩한 경우에도
 * 참조변수의 타입에 관계없이 항상 실제 인스턴스의 메서드(실제 인스턴스가 자손 인스턴스인 경우 오버라이딩된 메서드)가 호출되지만,
 * 멤버 변수의 경우에는 참조변수의 타입에 따라 달라진다.
 *
 * 위 코드에서 p는 Parent2 타입의 참조변수이고, c는 Child2 타입의 참조변수입니다.
 * 따라서 p.x는 Parent2 클래스의 x 멤버 변수인 100을 출력하고, p.method()는 Child2 클래스에서 오버라이딩된
 * method() 메서드인 "Child Method"를 출력합니다.
 *
 * c.x는 Child2 클래스의 x 멤버 변수인 200을 출력하고, c.method() 역시 Child2 클래스의 method() 메서드인
 * "Child Method"를 출력합니다. */
