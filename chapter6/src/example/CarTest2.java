package example;

class Car2 {
    String color;		// 색상
    String gearType;	// 변속기 종류 - auto(자동), manual(수동)
    int door;			// 문의 개수

    Car2() {
        this("white", "auto", 4);
    }
    /* Car2() {
        color = "white";
        gearType = "auto";
        door = 4;
    } */
    /* 위의 두 코드는 같은 일을 하지만 위쪽의 코드는 생성자 Car2(String color, String gearType, int door)를 활영해서 더 간략히 한 것이다. */

    Car2(String color) {
        this(color, "auto", 4);
    }
    Car2(String color, String gearType, int door) {
        this.color    = color;
        this.gearType = gearType;
        this.door     = door;
    }
    /* Car2(String c, String g, int d) {
        color    = c;
        gearType = g;
        door     = d;
    } */
    /* 생성자의 매개변수로 인스턴스변수들의 초기값을 제공받는 경우가 많기 떄문에 매개변수와 인스턴스 변수의 이름이 일치하는 경우가 자주 있다.
    이때는 아래쪽의 매개변수와 같이 이름을 다르게 하는 것 보다 위쪽의 코드와 같이 this를 사용해서 구별되도록 하는 것이 의미가 더 명확하고 이해하기 쉽다. */

    /* this를 사용할 수 있는 것은 인스턴스멤버뿐이다.
    static메서드(클래스메서드)에서는 인스턴스 멤버들을 사용할 수 없는 것처럼, this역시 사용할 수 없다.
    왜냐하면, static매서드는 인스턴스를 생성하지 않고도 호출될 수 있으므로 static메서드가 호출된 시점에 인스턴스가 존재하지 않을 수도 있기 때문이다. */
}

class CarTest2 {
    public static void main(String[] args) {
        Car2 c1 = new Car2();
        Car2 c2 = new Car2("blue");

        System.out.println("c1의 color=" + c1.color + ", gearType=" + c1.gearType + ", door=" + c1.door);
        System.out.println("c2의 color=" + c2.color + ", gearType=" + c2.gearType + ", door=" + c2.door);
    }
}
