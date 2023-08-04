package example;

public class TimeTest {
    public static void main(String[] args)
    {
        // Time 객체 생성과 초기화
        Time t = new Time(12, 35, 30);
        System.out.println(t); // 시간 정보 출력, toString() 메서드 호출

        // 시간을 1시간 뒤로 변경
        t.setHour(t.getHour()+1);   // 시간을 1시간 뒤로 변경
        System.out.println(t);      // 변경된 시간 정보 출력, toString() 메서드 호출
    }
}

class Time {
    private int hour;
    private int minute;
    private int second;

    Time(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    // 시간(hour)의 getter와 setter
    public int getHour() { return hour; }
    public void setHour(int hour) {
        // 시간 값의 유효성 검사
        if (hour < 0 || hour > 23) return;
        this.hour = hour;
    }

    // 분(minute)의 getter와 setter
    public int getMinute() { return minute; }
    public void setMinute(int minute) {
        // 분 값의 유효성 검사
        if (minute < 0 || minute > 59) return;
        this.minute = minute;
    }

    // 초(second)의 getter와 setter
    public int getSecond() { return second; }
    public void setSecond(int second) {
        // 초 값의 유효성 검사
        if (second < 0 || second > 59) return;
        this.second = second;
    }

    // 시간 정보를 "시:분:초" 형식의 문자열로 반환하는 toString() 메서드
    public String toString() {
        return hour + ":" + minute + ":" + second;
    }
}

