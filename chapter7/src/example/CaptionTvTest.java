package example;

class Tv {
    boolean power;   // 전원 상태(on/off)
    int channel;    // 채널

    void power() {   // 전원을 켜거나 끄는 메서드
        power = !power;
    }

    void channelUp() {    // 채널을 올리는 메서드
        ++channel;
    }

    void channelDown() {  // 채널을 내리는 메서드
        --channel;
    }
}

class CaptionTv extends Tv {
    boolean caption;      // 캡션 상태(on/off)

    void displayCaption(String text) { // 캡션을 화면에 출력하는 메서드
        if (caption) {  // 캡션 상태가 on(true)일 때만 text를 보여준다.
            System.out.println(text);
        }
    }
}

class CaptionTvTest {
    public static void main(String args[]) {
        CaptionTv ctv = new CaptionTv(); // CaptionTv 객체 생성
        ctv.channel = 10;                // Tv 클래스로부터 상속받은 멤버인 channel에 10을 설정
        ctv.channelUp();                 // Tv 클래스로부터 상속받은 메서드인 channelUp() 호출하여 채널을 1 증가
        System.out.println(ctv.channel); // 현재 채널을 출력 (11)

        ctv.displayCaption("Hello, World"); // CaptionTv 클래스의 메서드인 displayCaption() 호출하여 캡션 출력 (캡션 상태가 off이므로 출력되지 않음)

        ctv.caption = true;                      // 캡션 기능을 켬 (caption 변수를 true로 설정)
        ctv.displayCaption("Hello, World");      // 캡션 상태가 on이므로 "Hello, World"를 출력
    }
}

