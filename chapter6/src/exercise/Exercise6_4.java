package exercise;

class Exercise6_4 {
    public static void main(String args[]) {
        // Student 객체 생성 및 초기화
        Student s = new Student();
        s.name = "홍길동";
        s.ban = 1;
        s.no = 1;
        s.kor = 100;
        s.eng = 60;
        s.math = 76;

        // 학생 정보 출력
        System.out.println("이름: " + s.name);
        System.out.println("총점: " + s.getTotal());
        System.out.println("평균: " + s.getAverage());
    }
}

class Student {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    // 총점 계산 메서드
    int getTotal() {
        return kor + eng + math;
    }

    // 평균 계산 메서드
    float getAverage() {
        int total = getTotal();
        float average = (float) total / 3;
        return Math.round(average * 10) / 10.0f; // 소수점 둘째 자리에서 반올림
    }
}