package example;

class CastingTest1 {
    public static void main(String args[]) {
        Car car = null;        // Car 클래스 변수 car를 선언하고 초기값으로 null을 설정
        FireEngine fe = new FireEngine();    // FireEngine 객체 fe를 생성
        FireEngine fe2 = null;    // FireEngine 클래스 변수 fe2를 선언하고 초기값으로 null을 설정

        fe.water();    // FireEngine 객체 fe의 water() 메서드 호출 (출력: water!!!)

        car = fe;    // car 변수에 fe 객체를 대입 (자동 형변환, 업캐스팅)
        // car = (Car)fe;와 같은 의미, FireEngine 클래스는 Car 클래스를 상속받았으므로 Car 클래스 변수에 FireEngine 객체를 대입할 수 있다.

        // car.water();는 컴파일 에러 발생
        // Car 클래스에는 water() 메서드가 없기 때문에 컴파일 에러가 발생한다.
        // 컴파일 시점에는 car 변수가 Car 타입이므로 Car 클래스의 멤버만 사용 가능하다.

        fe2 = (FireEngine) car;    // car 변수에 저장된 객체를 FireEngine 타입으로 강제 형변환 (다운캐스팅)
        // fe2 = car;는 컴파일 에러 발생
        // car 변수는 컴파일 시점에는 Car 타입으로 선언되어 있으므로 FireEngine 클래스의 멤버를 사용할 수 없다.
        // 따라서 강제 형변환을 통해 FireEngine 타입으로 다운캐스팅 해야 한다.

        fe2.water();    // FireEngine 객체 fe2의 water() 메서드 호출 (출력: water!!!)
    }
}

class Car {
    String color;
    int door;

    void drive() {    // 운전하는 메서드
        System.out.println("drive, Brrrr~");
    }

    void stop() {    // 멈추는 메서드
        System.out.println("stop!!!");
    }
}

class FireEngine extends Car {    // 소방차 클래스, Car 클래스를 상속받음
    void water() {    // 물을 뿌리는 메서드
        System.out.println("water!!!");
    }
}

