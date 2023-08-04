package exercise;

/* Exercise 7-18.
 * 다음과 같은 실행결과를 얻도록 코드를 완성하시오.
 * [Hint] instanceof 연산자를 사용해서 형변환한다.
 *
 * 메서드명: action
 * 기능: 주어진 객체의 메서드를 호출한다.
 *       DanceRobot인 경우, dance()를 호출하고,
 *       SingRobot인 경우, sing()를 호출하고,
 *       DrawRobot인 경우, draw()를 호출한다.
 * 반환타입: 없음 (void)
 * 매개변수: Robot r - Robot 인스턴스 또는 Robot의 자손 인스턴스
 */
class Exercise7_18 {

    // action 메서드는 Robot 인스턴스 또는 그 자손 인스턴스를 인자로 받아서,
    // 해당하는 Robot의 서브클래스에 따라 각각의 메서드(dance, sing, draw)를 호출하는 역할을 한다.
    static void action(Robot r) {
        if (r instanceof DanceRobot){
            // r이 DanceRobot 타입인 경우, 형변환을 통해 DanceRobot 메서드인 dance()를 호출한다.
            ((DanceRobot) r).dance();
        } else if (r instanceof SingRobot) {
            // r이 SingRobot 타입인 경우, 형변환을 통해 SingRobot 메서드인 sing()를 호출한다.
            ((SingRobot) r).sing();
        } else if (r instanceof DrawRobot) {
            // r이 DrawRobot 타입인 경우, 형변환을 통해 DrawRobot 메서드인 draw()를 호출한다.
            ((DrawRobot) r).draw();
        }
    }

    public static void main(String[] args) {
        // Robot 배열을 생성하고, DanceRobot, SingRobot, DrawRobot 인스턴스를 배열에 저장한다.
        Robot[] arr = { new DanceRobot(), new SingRobot(), new DrawRobot() };

        // 배열의 각 요소에 대해 action 메서드를 호출합니다.
        for (int i=0; i<arr.length; i++)
            action(arr[i]);
    }
}

// Robot 클래스는 기본 클래스로, DanceRobot, SingRobot, DrawRobot의 공통 기능을 포함하지만,
// 직접적으로 인스턴스 생성은 되지 않는다.
class Robot {}

// DanceRobot 클래스는 Robot 클래스를 상속받아서, Robot의 기능을 확장하여 dance() 메서드를 추가한다.
class DanceRobot extends Robot {
    void dance() {
        System.out.println("춤을 춥니다.");
    }
}

// SingRobot 클래스는 Robot 클래스를 상속받아서, Robot의 기능을 확장하여 sing() 메서드를 추가한다.
class SingRobot extends Robot {
    void sing() {
        System.out.println("노래를 합니다.");
    }
}

// DrawRobot 클래스는 Robot 클래스를 상속받아서, Robot의 기능을 확장하여 draw() 메서드를 추가한다.
class DrawRobot extends Robot {
    void draw() {
        System.out.println("그림을 그립니다.");
    }
}
