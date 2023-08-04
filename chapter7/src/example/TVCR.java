package example;

class Tv2 {
    boolean power; 	// 전원 상태(on/off)
    int channel;		// 채널

    void power()       { 	power = !power; }		// 전원 켜기/끄기 메서드
    void channelUp()   { 	++channel; 		}		// 채널 증가 메서드
    void channelDown() {	--channel; 		}		// 채널 감소 메서드
}

class VCR {
    boolean power; 	// 전원 상태(on/off)
    int counter = 0;   // 카운터(영상 재생 시간 등을 표시하는 변수)

    void power() { 	power = !power; }		// 전원 켜기/끄기 메서드
    void play()  { /* 비디오 재생하는 동작을 수행하는 메서드 */ }
    void stop()  { /* 비디오 정지하는 동작을 수행하는 메서드 */ }
    void rew()   { /* 비디오 되감기하는 동작을 수행하는 메서드 */ }
    void ff()    { /* 비디오 빨리 감기하는 동작을 수행하는 메서드 */ }
}

class TVCR extends Tv2 {
    VCR vcr = new VCR();   // VCR 클래스를 포함하는 객체 생성
    int counter = vcr.counter;  // VCR 클래스의 카운터 값을 저장

    void play() {
        vcr.play();   // VCR 클래스의 play() 메서드 호출
    }

    void stop() {
        vcr.stop();   // VCR 클래스의 stop() 메서드 호출
    }

    void rew() {
        vcr.rew();   // VCR 클래스의 rew() 메서드 호출
    }

    void ff() {
        vcr.ff();	// VCR 클래스의 ff() 메서드 호출
    }
}

