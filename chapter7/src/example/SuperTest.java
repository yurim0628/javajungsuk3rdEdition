package example;

class SuperTest {
    public static void main(String args[]) {
        Child2 c = new Child2();
        c.method();
    }
}

class Parent2 {
    int x = 10;
}

class Child2 extends Parent2 {
    void method() {
        System.out.println("x=" + x);        // 현재 클래스의 멤버 변수 x 출력
        System.out.println("this.x=" + this.x);  // 현재 클래스의 멤버 변수 x 출력
        System.out.println("super.x=" + super.x); // 상위 클래스의 멤버 변수 x 출력
    }
}

