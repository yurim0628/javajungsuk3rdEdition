package example;

class SuperTest2 {
    public static void main(String args[]) {
        Child6 c = new Child6();
        c.method();
    }
}

class Parent6 {
    int x = 10;
}

class Child6 extends Parent6 {
    int x = 20;

    void method() {
        System.out.println("x=" + x);        // Child6 클래스의 멤버 변수 x 출력
        System.out.println("this.x=" + this.x);  // Child6 클래스의 멤버 변수 x 출력
        System.out.println("super.x=" + super.x); // Parent6 클래스의 멤버 변수 x 출력
    }
}

