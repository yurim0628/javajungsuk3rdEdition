package example;

import java.text.SimpleDateFormat; // SimpleDateFormat 클래스를 사용하기 위해 import문 선언
import java.util.Date; // Date 클래스를 사용하기 위해 import문 선언

class ImportTest {
    public static void main(String[] args) {
        Date today = new Date(); // 현재 날짜와 시간 정보를 담고 있는 Date 객체 생성

        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd"); // 날짜 형식 지정을 위한 SimpleDateFormat 객체 생성
        SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a"); // 시간 형식 지정을 위한 SimpleDateFormat 객체 생성

        System.out.println("오늘 날짜는 " + date.format(today)); // 오늘 날짜를 지정한 형식으로 출력
        System.out.println("현재 시간은 " + time.format(today)); // 현재 시간을 지정한 형식으로 출력
    }
}

