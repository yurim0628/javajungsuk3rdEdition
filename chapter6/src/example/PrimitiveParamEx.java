package example;

class Data { int x; }

class PrimitiveParamEx {
    public static void main(String[] args) {
        Data d = new Data();
        d.x = 10;
        System.out.println("main() : x = " + d.x);

        change(d.x);
        /* change메서드가 호출되면서 d.x가 change메서드의 매개변수 x에 복사된다. */
        System.out.println("After change(d.x)");
        System.out.println("main() : x = " + d.x);
        /* change메서드가 종료되면서 매개변수 x는 스택에서 제거된다. */
    }

    static void change(int x) {  // 기본형 매개변수
        x = 1000;
        /* change메서드에서 x의 값을 1000으로 변경된다. */
        System.out.println("change() : x = " + x);
    }
    /* d.x의 값이 변경된 것이 아니라, change메서드의 매개변수 x의 값이 변경된 것이다.
    즉, 원본이 아닌 복사본이 변경된 것이라 원본에는 아무런 영향을 미치지 못한다.
    이처럼 기본형 매개변수는 변수에 저장된 갓만 읽을 수 있을 뿐 변경할 수는 없다. */
}
