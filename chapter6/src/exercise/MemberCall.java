package exercise;

class MemberCall {
    int iv = 10;
    static int cv = 20;

    static void staticMethod1() {
        System.out.println(cv); // 정적 변수 cv 출력
        // System.out.println(iv); // 에러: 정적 메서드에서 인스턴스 변수 iv에 접근 불가
    }

    void instanceMethod1() {
        System.out.println(cv); // 정적 변수 cv 출력
        System.out.println(iv); // 인스턴스 변수 iv 출력
    }

    static void staticMethod2() {
        staticMethod1(); // 정적 메서드 staticMethod1() 호출
        // instanceMethod1(); // 에러: 정적 메서드에서 인스턴스 메서드 호출 불가
    }

    void instanceMethod2() {
        staticMethod1(); // 정적 메서드 staticMethod1() 호출
        instanceMethod1(); // 인스턴스 메서드 instanceMethod1() 호출
    }
}

