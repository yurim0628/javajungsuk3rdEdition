package example;

class InnerEx3 {
    private int outerIv = 0;
    static int outerCv = 0;

    class InstanceInner {
        int iiv  = outerIv; // 외부 클래스의 private 인스턴스 변수에 접근 가능
        int iiv2 = outerCv; // 외부 클래스의 static 클래스 변수에 접근 가능
    }

    static class StaticInner {
        // 정적(static) 내부 클래스는 외부 클래스의 인스턴스 변수에 직접 접근할 수 없음
//      int siv = outerIv; // 에러 발생!
        static int scv = outerCv; // 정적 내부 클래스에서는 외부 클래스의 static 변수에 접근 가능
    }

    void myMethod() {
        int lv = 0;
        final int LV = 0; // JDK 1.8 이후에는 final 키워드 없이도 메서드 내부에서 사용 가능

        class LocalInner {
            int liv = outerIv; // 외부 클래스의 private 인스턴스 변수에 접근 가능
            int liv2 = outerCv; // 외부 클래스의 static 클래스 변수에 접근 가능
            // 메서드 내부에서 지역 변수 lv는 final 특성을 가져야만 사용 가능(Java 8 이전)
//          int liv3 = lv; // 에러 발생! (JDK 1.8 이전)
            int liv4 = LV; // OK (final 특성이 적용되어 사용 가능)
        }
    }
}

