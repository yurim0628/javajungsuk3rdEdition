package example;

// class Data { int x; }

class ReferenceParamEx {
    public static void main(String[] args) {
        Data d = new Data();
        d.x = 10;
        System.out.println("main() : x = " + d.x);

        change(d);
        /* change메서드가 호출되면서 참조변수 d의 값(주소)이 매개변수 d에 저장된다. */
        System.out.println("After change(d)");
        System.out.println("main() : x = " + d.x);
        /* change메서드의 매개변수를 참조형으로 선언했기 때문에, x의 값이 아닌 주소가 매개변수 d에 복사되었다.
        main메서드의 참조변수 d와 change메서드의 참조변수 d가 같은 객체를 가리키게 된다.
        change메서드가 종료되면서 매개변수 d는 스택에서 제거되었지만, d.x의 값이 변경된 것을 확인할 수 있다. */
    }

    static void change(Data d) { // 참조형 매개변수
        d.x = 1000;
        /* change메서드에서 매개변수 d로 x의 값을 1000으로 변경된다. */
        System.out.println("change() : x = " + d.x);
    }
}
