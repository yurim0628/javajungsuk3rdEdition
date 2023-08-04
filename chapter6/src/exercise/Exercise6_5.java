package exercise;

class Exercise6_5 {
    public static void main(String args[]) {
        // Student2 객체 생성 및 초기화
        Student2 s = new Student2("홍길동", 1, 1, 100, 60, 76);

        // 학생 정보 출력
        System.out.println(s.info());
    }
}

class Student2 {
    String name;  // 학생 이름
    int ban;      // 반
    int no;       // 번호
    int kor;      // 국어 점수
    int eng;      // 영어 점수
    int math;     // 수학 점수

    // 생성자
    Student2(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    // 학생 정보 반환
    String info() {
        int total = kor + eng + math;
        float average = (float) total / 3;
        average = Math.round(average * 10) / 10.0f;
        String result = name + "," + + ban + "," + no + "," + kor + "," + eng + "," + math + "," + total + "," + average;
        return result;
    }
}