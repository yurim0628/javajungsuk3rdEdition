package example;

class Car3 {
    String color;		// 색상
    String gearType;    // 변속기 종류 - auto(자동), manual(수동)
    int door;			// 문의 개수

    Car3() {
        this("white", "auto", 4);
    }

    Car3(Car3 c) {	// 인스턴스의 복사를 위한 생성자
        color    = c.color;
        gearType = c.gearType;
        door     = c.door;
    }

    Car3(String color, String gearType, int door) {
        this.color    = color;
        this.gearType = gearType;
        this.door     = door;
    }
}
class CarTest3 {
    public static void main(String[] args) {
        Car3 c1 = new Car3();
        Car3 c2 = new Car3(c1);	// c1의 복사본 c2를 생성
        /* 인스턴스 c2는 c1을 복사하여 생성된 것이므로 서로 같은 상태를 갖지만,
        서로 독립적으로 메모리공간에 존재하는 별도의 인스턴스이므로 c1의 값들이 변경되어도 c2는 영향을 받지 않는다. */
        System.out.println("c1의 color=" + c1.color + ", gearType=" + c1.gearType+ ", door="+c1.door);
        System.out.println("c2의 color=" + c2.color + ", gearType=" + c2.gearType+ ", door="+c2.door);

        c1.door=100;	// c1의 인스턴스변수 door의 값을 변경
        System.out.println("c1.door=100; 수행 후");
        System.out.println("c1의 color=" + c1.color + ", gearType=" + c1.gearType+ ", door="+c1.door);
        System.out.println("c2의 color=" + c2.color + ", gearType=" + c2.gearType+ ", door="+c2.door);
    }
}
