package example;

class TvTest3 {
    public static void main(String args[]) {
        Tv t1 = new Tv();
        Tv t2 = new Tv();
        System.out.println("t1의 channel값은 " + t1.channel + "입니다.");
        System.out.println("t2의 channel값은 " + t2.channel + "입니다.");

        t2 = t1;		// t1이 저장하고 있는 값(주소)을 t2에 저장
        /* t1은 참조변수이므로, 인스턴스의 주소를 저장하고 있다.
        이 문장이 수행되면, t2가 가지고 있던 값은 잃어버리게 되고 t1에 저장되어 있던 값이 t2에 저장되게 된다.
        그렇게 되면 t2 역시 t1이 참조하고 있던 인스턴스를 같이 참조하게 되고, t2가 원래 참조하고 있던 인스턴스는 더 이상 사용할 수 없게 된다. */

        t1.channel = 7;	// channel 값을 7로 설정
        System.out.println("t1의 channel값을 7로 변경하였습니다.");

        System.out.println("t1의 channel값은 " + t1.channel + "입니다.");
        System.out.println("t2의 channel값은 " + t2.channel + "입니다.");
        /* 참조변수에는 하나의 값(주소)만이 저장될 수 있으므로
        둘 이상의 참조변수가 하나의 인스턴스를 가리키는(참조하는) 것은 가능하지만 하나의 참조변수로 여러 개의 인스턴스를 가리키는 것은 가능하지 않다. */
    }
}

/*
class Tv {
     // Tv의 속성(멤버변수)
     String color;           // 색상
     boolean power;          // 전원상태(on/off)
     int channel;          	 // 채널

     // Tv의 기능(메서드)
     void power()   { power = !power; }  // TV를 켜거나 끄는 기능을 하는 메서드
     void channelUp()   {  ++channel; }  // TV의 채널을 높이는 기능을 하는 메서드
     void channelDown() {  --channel; }  // TV의 채널을 낮추는 기능을 하는 메서드
}
 */
