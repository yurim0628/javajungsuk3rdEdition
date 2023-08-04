package example;

// Outer2 클래스 선언
class Outer2 {
    int value = 10; // Outer2 클래스의 인스턴스 변수 value

    // Inner 클래스 선언
    class Inner {
        int value = 20; // Inner 클래스의 인스턴스 변수 value

        // method1() 메서드 선언
        void method1() {
            int value = 30; // method1() 메서드의 지역 변수 value

            // method1() 메서드 내에서 각 변수의 값 출력
            System.out.println("            value : " + value); // 지역 변수 value 출력
            System.out.println("       this.value : " + this.value); // Inner 클래스의 인스턴스 변수 value 출력
            System.out.println("Outer2.this.value : " + Outer2.this.value); // Outer2 클래스의 인스턴스 변수 value 출력
        }
    } // Inner 클래스의 끝
} // Outer2 클래스의 끝

// InnerEx5 클래스 선언
class InnerEx5 {
    public static void main(String args[]) {
        // Outer2 클래스의 인스턴스 생성
        Outer2 outer = new Outer2();

        // Outer2 클래스의 인스턴스에 속하는 Inner 클래스의 인스턴스 생성
        Outer2.Inner inner = outer.new Inner();

        // Inner 클래스의 메서드 method1() 호출
        inner.method1();
    }
} // InnerEx5 클래스의 끝
