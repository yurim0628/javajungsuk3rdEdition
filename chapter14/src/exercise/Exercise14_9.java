package exercise;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

/* Exercise 14-9. 다음은 각 반별 총점을 학년 별로 나누어 출력하는 프로그램이다. */
/* (1)에 알맞은 코드를 넣어 완성하시오. */
class Exercise14_9 {
    public static void main(String[] args) {
        // Student 객체 배열 생성
        Student[] stuArr = {
                // 학생 정보 초기화
        };

        // 학년과 반별 총점을 계산하여 맵으로 저장
        Map<Integer, Map<Integer, Long>> totalScoreByHakAndBan =
                /* (1) 알맞은 코드를 넣으시오. */
                Stream.of(stuArr).collect(groupingBy(
                        Student::getHak, groupingBy(
                                Student::getBan, summingLong(Student::getScore)
                        )
                ));

        // 학년과 반별 총점 출력
        for (Map.Entry<Integer, Map<Integer, Long>> entry : totalScoreByHakAndBan.entrySet()) {
            int hak = entry.getKey();
            Map<Integer, Long> banScoreMap = entry.getValue();

            for (Map.Entry<Integer, Long> banEntry : banScoreMap.entrySet()) {
                int ban = banEntry.getKey();
                long totalScore = banEntry.getValue();
                System.out.println(hak + "학년 " + ban + "반의 총점: " + totalScore);
            }
        }
    }
}

class Student {
    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;

    // 생성자와 Getter 메서드들

    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점]", name, isMale ? "남" : "여", hak, ban, score);
    }

    // groupingBy()에서 사용하는 열거형
    enum Level { HIGH, MID, LOW }
}
