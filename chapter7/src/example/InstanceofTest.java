package example;

class InstanceofTest {
    public static void main(String args[]) {
        FireEngine2 fe = new FireEngine2();

        // instanceof 연산자를 사용하여 객체의 타입을 확인합니다.
        if (fe instanceof FireEngine2) {
            System.out.println("This is a FireEngine2 instance.");
        }

        // FireEngine2 클래스는 Car2 클래스를 상속받았으므로 true가 됩니다.
        if (fe instanceof Car2) {
            System.out.println("This is a Car2 instance.");
        }

        // 모든 클래스는 Object 클래스를 상속받으므로 true가 됩니다.
        if (fe instanceof Object) {
            System.out.println("This is an Object instance.");
        }

        // getClass() 메서드를 사용하여 객체의 클래스 정보를 가져온 뒤, getName() 메서드를 호출하여 클래스 이름을 출력합니다.
        System.out.println(fe.getClass().getName()); // 출력 결과: FireEngine2
    }
}

class Car2 {
    // Car2 클래스는 아무런 멤버 변수와 메서드를 가지지 않는 간단한 클래스입니다.
}

class FireEngine2 extends Car2 {
    // FireEngine2 클래스는 Car2 클래스를 상속받았으며, 추가적인 멤버 변수나 메서드를 가지고 있을 수 있습니다.
}

