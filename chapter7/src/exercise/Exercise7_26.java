package exercise;

/* Exercise 7-26. Outer클래스의 내부클래스 Inner의 멤버변수 iv의 값을 출력하시오. */

class Outer2 {
    static class Inner {
        int iv = 200;
    }
}

class Exercise7_26 {
    public static void main(String[] args) {
        Outer2.Inner inner = new Outer2.Inner();
        System.out.println(inner.iv);
        System.out.println(new Outer2.Inner().iv);	// 위의 두 줄을 한 줄로 축약
    }
}

/* [해설]
   * 내부 스태틱 클래스(static inner class)는 인스턴스 클래스와 달리
   * 외부클래스의 인스턴스를 생성하지 않고도 사용할 수 있다.
   * 이는 클래스의 static멤버를 인스턴스 생성없이 사용할 수 있는 것과 같은 원리이다. */