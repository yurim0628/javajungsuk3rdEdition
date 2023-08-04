package example;

class TvTest4 {
    public static void main(String args[]) {
        Tv[] tvArr = new Tv[3]; // 길이가 3인 Tv객체 배열
        /* 각 요소는 참조변수의 기본값인 null로 자동 초기화 된다. 그리고 이 객체 배열은 3개의 객체의 주소를 저장할 수 있다.
        객체 배열을 생성하는 것은 객체를 다루기 위한 참조변수들이 만들어진 것일 뿐 아직 객체가 저장되지 않았다.
         */

        // Tv객체를 생성해서 Tv객체 배열의 각 요소에 저장
        for(int i=0; i < tvArr.length;i++) {
            tvArr[i] = new Tv();
            tvArr[i].channel = i+10; // tvArr[i]의 channel에 i+10을 저장
        }
        /* 다음과 같이 배열의 초기화 블럭을 사용하면 간단하게 객체를 생성할 수 있다.
        Tv[] tvArr = { new Tv(), new Tv(), new Tv() } */

        for(int i=0; i < tvArr.length;i++) {
            tvArr[i].channelUp();  // tvArr[i]의 메서드를 호출. 채널이 1증가
            System.out.printf("tvArr[%d].channel=%d%n",i,tvArr[i].channel);
        }
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
