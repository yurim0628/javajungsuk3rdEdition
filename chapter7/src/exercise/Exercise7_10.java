package exercise;

/* Exercise 7-10. MyTv2클래스의 멤버변수 isPowerOn, channel, volume을
 * 클래스 외부에서 접근할 수 없도록 제어자를 붙이고
 * 대신 이 멤버변수들의 값을 어디서나 읽고 변경할 수 있도록
 * getter와 setter메서드를 추가하라. */

class MyTv2 {
    private boolean isPowerOn; // TV 전원 상태를 나타내는 변수 (true: 켜짐, false: 꺼짐)
    private int channel;      // TV 채널을 나타내는 변수
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
        this.channel = channel;
    }

    // TV 볼륨 반환 메서드
    public int getVolume() { return volume;}
    // TV 볼륨 설정 메서드
    public void setVolume(int volume) {
        // 유효한 볼륨 값인지 확인하여 유효하지 않으면 설정하지 않고 반환한다.
        if (volume > MAX_VOLUME || volume < MIN_VOLUME)
            return;
        this.volume = volume;
    }
}

class Exercise7_10 {
    public static void main(String[] args) {
        MyTv2 t = new MyTv2();

        t.setChannel(10); // TV 채널을 10으로 설정한다.
        System.out.println("CH : " + t.getChannel()); // 현재 채널 출력
        t.setVolume(20); // TV 볼륨을 20으로 설정한다.
        System.out.println("VOL : " + t.getVolume()); // 현재 볼륨 출력
    }
}