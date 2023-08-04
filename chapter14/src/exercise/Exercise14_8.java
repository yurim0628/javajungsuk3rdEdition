package exercise;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

/* Exercise 14-8. 다음은 불합격(150점 미만)한 학생의 수를 남자와 여자로 구별하여 출력하는 프로그램이다. */
/* (1)에 알맞은 코드를 넣어 완성하시오. */
class Exercise14_8 {
    public static void main(String[] args) {
        // Student 객체 배열 생성
        Student[] stuArr = {
                // 학생 정보 초기화
        };

        // 학생들을 남녀로 구분하여 불합격 여부를 세는 맵 생성
        Map<Boolean, Map<Boolean, Long>> failedStuBySex =
                /* (1) 알맞은 코드를 넣으시오. */
                Stream.of(stuArr).collect(partitioningBy(
                        Student::isMale, partitioningBy(
                                s -> s.getScore() < 150, counting()
                        )
                ));

        // 남학생 불합격 수와 여학생 불합격 수 가져오기
        long failedMaleStuNum = failedStuBySex.get(true).get(true);
        long failedFemaleStuNum = failedStuBySex.get(false).get(true);

        // 결과 출력
        System.out.println("불합격[남자] : " + failedMaleStuNum + "명");
        System.out.println("불합격[여자] : " + failedFemaleStuNum + "명");
    }
}

class Student {
    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;

    // 생성자
    Student(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    // Getter 메서드들
    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점]", name, isMale ? "남" : "여", hak, ban, score);
    }

    // groupingBy()에서 사용하는 열거형
    enum Level { HIGH, MID, LOW }
}
