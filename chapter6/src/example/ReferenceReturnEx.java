package example;

class Data3 { int x; }

class ReferenceReturnEx {
    public static void main(String[] args)
    {
        Data3 d = new Data3();
        d.x = 10;

        Data3 d2 = copy(d);
        /* copy메서드를 호출하면서 참조변수 d의 값이 매개변수 d에 복사된다. */
        /* copy 메서드의 반환 타입이 Data3이므로 호출결과를 저장하는 변수의 타입 역시 Data3타입의 참조변수이어야 한다. */
        System.out.println("d.x ="+d.x);
        System.out.println("d2.x="+d2.x);
        /* copy메서드가 종료되어 tmp가 사라졌지만, d2로 새로운 객체를 다룰 수 있다. */
    }

    static Data3 copy(Data3 d) {
        /* 반환하는 값이 Data3객체의 주솟이므로 반환타입이 Data3인 것이다. */
        Data3 tmp = new Data3();
        tmp.x = d.x;
        /* 새로운 객체를 생성한 다음, d.x에 저장된 값을 tmp.x에 복사한다. */

        return tmp;
        /* copy메서드가 종료되면서 반환한 tmp의 값은 참조변수 d2에 저장된다. */
        /* 반환타입이 참조형이라는 것은 메서드가 객체의 주소를 반환한다는 것을 의미한다. */
    }
    /* copy메서드는 새로운 객체를 생성한 다음에, 매개변수로 넘겨받은 객체에 저장된 값을 복사해서 반환한다. */
}