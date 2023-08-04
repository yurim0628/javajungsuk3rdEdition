package example;

class InnerEx2 {
    class InstanceInner {} // 인스턴스 내부 클래스 선언
    static class StaticInner {} // 정적(static) 내부 클래스 선언

    // 인스턴스 내부 클래스의 객체를 생성하여 인스턴스 변수(iv)에 저장
    InstanceInner iv = new InstanceInner();
    // 정적 내부 클래스의 객체를 생성하여 정적 변수(cv)에 저장
    static StaticInner cv = new StaticInner();

    static void staticMethod() {
        // 정적 메서드에서는 인스턴스 내부 클래스의 객체를 직접 생성할 수 없음
//      InstanceInner obj1 = new InstanceInner();
        // 정적 내부 클래스의 객체는 정적 메서드에서 생성 가능
        StaticInner obj2 = new StaticInner();

        // 외부 클래스(InnerEx2)의 인스턴스를 통해 인스턴스 내부 클래스의 객체 생성
        InnerEx2 outer = new InnerEx2();
        InstanceInner obj1 = outer.new InstanceInner();
    }

    void instanceMethod() {
        // 인스턴스 메서드에서는 인스턴스 내부 클래스와 정적 내부 클래스의 객체 모두 생성 가능
        InstanceInner obj1 = new InstanceInner();
        StaticInner obj2 = new StaticInner();

        // 메서드 내에 지역 클래스(LocalInner) 선언 및 객체 생성
        class LocalInner {}
        LocalInner lv = new LocalInner();
    }

    void myMethod() {
        // 메서드 내에서 정의된 지역 클래스는 해당 메서드 내에서만 사용 가능
        class LocalInner {}
        LocalInner lv = new LocalInner();
    }
}

