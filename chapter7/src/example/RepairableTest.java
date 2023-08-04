package example;

class RepairableTest {
    public static void main(String[] args) {
        Tank tank = new Tank();
        Dropship dropship = new Dropship();

        Marine marine = new Marine();
        SCV scv = new SCV();

        scv.repair(tank); // SCV가 Tank를 수리함
        scv.repair(dropship); // SCV가 Dropship을 수리함
//		scv.repair(marine); // 에러 발생: SCV는 Marine을 수리할 수 없음
    }
}

// Repairable 인터페이스 (수리 가능한 인터페이스)
interface Repairable {}

// GroundUnit 클래스 (지상 유닛을 나타내는 클래스)
class GroundUnit extends Unit2 {
    GroundUnit(int hp) {
        super(hp);
    }
}

// AirUnit 클래스 (공중 유닛을 나타내는 클래스)
class AirUnit extends Unit2 {
    AirUnit(int hp) {
        super(hp);
    }
}

// Unit2 클래스 (유닛을 나타내는 클래스)
class Unit2 {
    int hitPoint; // 현재 체력
    final int MAX_HP; // 최대 체력
    Unit2(int hp) {
        MAX_HP = hp;
    }
    //...
}

// Tank 클래스 (Tank 유닛)
class Tank extends GroundUnit implements Repairable {
    Tank() {
        super(150); // Tank의 HP를 150으로 초기화
        hitPoint = MAX_HP;
    }

    public String toString() {
        return "Tank";
    }
    //...
}

// Dropship 클래스 (Dropship 유닛)
class Dropship extends AirUnit implements Repairable {
    Dropship() {
        super(125); // Dropship의 HP를 125로 초기화
        hitPoint = MAX_HP;
    }

    public String toString() {
        return "Dropship";
    }
    //...
}

// Marine 클래스 (Marine 유닛)
class Marine extends GroundUnit {
    Marine() {
        super(40);
        hitPoint = MAX_HP;
    }
    //...
}

// SCV 클래스 (SCV 유닛)
class SCV extends GroundUnit implements Repairable {
    SCV() {
        super(60);
        hitPoint = MAX_HP;
    }

    void repair(Repairable r) {
        if (r instanceof Unit2) {
            Unit2 u = (Unit2) r;
            while (u.hitPoint != u.MAX_HP) {
                /* Unit의 HP를 증가시킴. */
                u.hitPoint++;
            }
            System.out.println(u.toString() + "을/를 수리하였습니다.");
        }
    }
    //...
}

