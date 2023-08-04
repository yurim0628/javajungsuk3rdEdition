package example;

class MyMathTest {
    public static void main(String args[]) {
        MyMath mm = new MyMath();
        long result1 = mm.add(5L, 3L);
        /* main메서드에서 메서드 add를 호출한다.
        호출시 지정한 5L과 3L이 메서드 add의 매개변수 a, b에 각각 복사(대입)된다. */
        long result2 = mm.subtract(5L, 3L);
        long result3 = mm.multiply(5L, 3L);
        double result4 = mm.divide(5L, 3L);
        /* 인자는 메서드가 호출되면서 매개변수에 대입되므로, 인자의 타입은 매개변수의 타입과 일치하거나 자동 형변환이 가능한 것이어야 한다. */
        /* 메서드는 호출시 넘겨받은 값으로 연산을 수행하고 그 결과를 반환하면서 종료된다.
        반환된 값은 대입연산자에 의해서 변수 result에 저장된다.
        메서드의 결과를 저장하기 위한 변수 result역시 반환값과 같은 타입이거나 반환값이 자동 형 변한되어 저장될 수 있는 타입이어야 한다. */
        System.out.println("add(5L, 3L) = "      + result1);
        System.out.println("subtract(5L, 3L) = " + result2);
        System.out.println("multiply(5L, 3L) = " + result3);
        System.out.println("divide(5L, 3L) = "   + result4);
    }
}

class MyMath {
    long add(long a, long b) {
        long result = a+b;
        return result;
        //	return a + b;	// 위의 두 줄을 이와 같이 한 줄로 간단히 할 수 있음
        /* 메서드 add의 모든 문장이 실행되거나 return문을 만나면, 호출한 메서드(main메서드)로 되돌아가서 이후의 문장을 실행한다. */
    }

    long subtract(long a, long b) {
        return a - b;
    }

    long multiply(long a, long b) {
        return a * b;
    }

    double divide(double a, double b) {
        /* long형의 값인 5L과 3L은 double형 값인 5.0과 3.0으로 자동 형변환되어 divide의 매개변수 a와 b에 각각 저장된다. */
        return a / b;
    }
}
