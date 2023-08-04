package exercise;

/* Exercise 7-27. 다음과 같은 실행결과를 얻도록 (1)~(4)의 코드를 완성하시오.
 * [실행결과]
 * 30
 * 20
 * 10
*/

class Outer3 {
    int value = 10;

    class Inner {
        int value = 20;
        void method1() {
            int value = 30;

            System.out.println(value);
            System.out.println(this.value);
            System.out.println(Outer3.this.value);
        }
    }
}

class Exercise7_27 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();

    }
}