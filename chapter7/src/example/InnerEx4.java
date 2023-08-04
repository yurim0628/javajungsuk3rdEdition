package example;

// Outer 클래스 선언
class Outer {
    // 인스턴스 내부 클래스 선언
    class InstanceInner {
        int iv = 100;
    }

    // 정적(static) 내부 클래스 선언
    static class StaticInner {
        int iv = 200;
        static int cv = 300;
    }

    // 메서드 myMethod() 선언
    void myMethod() {
        // 지역 클래스 선언
        class LocalInner {
            int iv = 400;
        }
    }
}

// InnerEx4 클래스 선언
class InnerEx4 {
    public static void main(String[] args) {
        // Outer 클래스의 인스턴스를 생성하고, 인스턴스 내부 클래스의 인스턴스 생성
        Outer oc = new Outer();
        Outer.InstanceInner ii = oc.new InstanceInner();

        // 인스턴스 내부 클래스의 인스턴스 변수 출력
        System.out.println("ii.iv : " + ii.iv);

        // 정적 내부 클래스의 클래스 변수 출력
        System.out.println("Outer.StaticInner.cv : " + Outer.StaticInner.cv);

        // 정적 내부 클래스의 인스턴스 생성
        Outer.StaticInner si = new Outer.StaticInner();

        // 정적 내부 클래스의 인스턴스 변수 출력
        System.out.println("si.iv : " + si.iv);
    }
}

