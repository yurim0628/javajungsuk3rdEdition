package example;

class CastingTest2 {
    public static void main(String args[]) {
        Car car = new Car();    // Car 객체 car 생성
        Car car2 = null;        // Car 클래스 변수 car2를 선언하고 초기값으로 null을 설정
        FireEngine fe = null;    // FireEngine 클래스 변수 fe를 선언하고 초기값으로 null을 설정

        car.drive();    // car 객체의 drive() 메서드 호출 (출력: drive, Brrrr~)
        // car 객체는 Car 클래스의 인스턴스이므로 Car 클래스의 멤버인 drive() 메서드를 호출한다.

        fe = (FireEngine) car;    // car 변수에 저장된 객체를 FireEngine 타입으로 강제 형변환 (다운캐스팅)
        // fe = car;는 컴파일 에러 발생
        // car 변수는 컴파일 시점에는 Car 타입으로 선언되어 있으므로 FireEngine 클래스의 멤버를 사용할 수 없다.
        // 따라서 강제 형변환을 통해 FireEngine 타입으로 다운캐스팅 해야 한다.

        fe.drive();    // FireEngine 객체 fe의 drive() 메서드 호출 (출력: drive, Brrrr~)
        // 다운캐스팅된 fe 변수로 FireEngine 클래스의 멤버인 drive() 메서드를 호출한다.

        car2 = fe;    // car2 변수에 fe 객체를 대입 (자동 형변환, 업캐스팅)
        // car2 = (Car)fe;와 같은 의미, FireEngine 클래스는 Car 클래스를 상속받았으므로 Car 클래스 변수에 FireEngine 객체를 대입할 수 있다.

        car2.drive();    // car2 객체의 drive() 메서드 호출 (출력: drive, Brrrr~)
        // car2 객체는 Car 클래스 변수이지만, car2 변수에 저장된 객체는 FireEngine 타입이므로 FireEngine 클래스의 멤버인 drive() 메서드를 호출한다.
    }
}
