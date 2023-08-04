package exercise;

/* Exercise 7-11. 문제 7-10에서 작성한  MyTv2클래스에
 * 이전 채널(previous channel)로 이동하는 기능의 메서드를 추가해서
 * 실행결과와 같은 결과를 얻도록 하시오.
 * [Hint] 이전 채널의 값을 저장할 멤버변수를 정의하라.
 * 메서드명	: gotoPrevChannel
 * 기능		: 현재 채널을 이전 채널로 변경한다.
 * 반환타입	: 없음
 * 매개변수	: 없음 */

class MyTv3 {
    private boolean isPowerOn; // TV 전원 상태를 나타내는 변수 (true: 켜짐, false: 꺼짐)
    private int channel;      // TV 채널을 나타내는 변수
    private int prevChannel;  // 이전 채널을 저장하는 변수
    private int volume;       // TV 볼륨을 나타내는 변수
    final private int MAX_VOLUME = 100; // 볼륨의 최대값
    final private int MIN_VOLUME = 0;   // 볼륨의 최소값
    final private int MAX_CHANNEL = 100; // 채널의 최대값
    final private int MIN_CHANNEL = 1;   // 채널의 최소값

    // TV 전원 상태 반환 메서드
    public boolean getIsPowerOn() { return isPowerOn; }
    // TV 전원 상태 설정 메서드
    public void setIsPowerOn(boolean isPowerOn) { this.isPowerOn = isPowerOn; }

    // TV 채널 반환 메서드
    public int getChannel() { return channel; }
    // TV 채널 설정 메서드
    public void setChannel(int channel) {
        // 유효한 채널 값인지 확인하여 유효하지 않으면 설정하지 않고 반환한다.
        if (channel > MAX_CHANNEL || channel < MIN_CHANNEL)
            return;
        prevChannel = this.channel; // 현재 채널을 prevChannel에 저장한다.
        this.channel = channel;     // 새로운 채널로 설정한다.
    }

    // TV 볼륨 반환 메서드
    public int getVolume() { return volume; }
    // TV 볼륨 설정 메서드
    public void setVolume(int volume) {
        // 유효한 볼륨 값인지 확인하여 유효하지 않으면 설정하지 않고 반환한다.
        if (volume > MAX_VOLUME || volume < MIN_VOLUME)
            return;
        this.volume = volume;
    }

    // 이전 채널로 이동하는 메서드
    public void gotoPrevChannel() {
        setChannel(prevChannel);
    }
}

class Exercise7_11 {
    public static void main(String[] args) {
        MyTv3 t = new MyTv3();

        t.setChannel(10); // TV 채널을 10으로 설정한다.
        System.out.println("CH : " + t.getChannel()); // 현재 채널 출력
        t.setVolume(20); // TV 볼륨을 20으로 설정한다.
        System.out.println("VOL : " + t.getVolume()); // 현재 볼륨 출력

        t.gotoPrevChannel(); // 이전 채널로 이동한다.
        System.out.println("CH:"+t.getChannel()); // 이전 채널 출력

        t.gotoPrevChannel(); // 이전 채널로 이동한다.
        System.out.println("CH:"+t.getChannel()); // 이전 채널 출력
    }
}

