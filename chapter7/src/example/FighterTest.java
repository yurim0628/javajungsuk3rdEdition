package example;

// FighterTest 클래스
public class FighterTest {
    public static void main(String[] args) {
        // Fighter 객체 생성
        Fighter f = new Fighter();

        // Fighter 객체가 어떤 인터페이스나 클래스를 구현하거나 상속받았는지 확인하여 결과를 출력
        if (f instanceof Unit) {
            System.out.println("f는 Unit 클래스의 자손입니다.");
        }
        if (f instanceof Fightable) {
            System.out.println("f는 Fightable 인터페이스를 구현했습니다.");
        }
        if (f instanceof Movable) {
            System.out.println("f는 Movable 인터페이스를 구현했습니다.");
        }
        if (f instanceof Attackable) {
            System.out.println("f는 Attackable 인터페이스를 구현했습니다.");
        }
        if (f instanceof Object) {
            System.out.println("f는 Object 클래스의 자손입니다.");
        }
    }
}

// Fighter 클래스 - Unit 클래스를 상속하고, Fightable 인터페이스를 구현
class Fighter extends Unit implements Fightable {
    public void move(int x, int y) { /* 이동 기능 구현 */ }
    public void attack(Unit u) { /* 공격 기능 구현 */ }
}

// Unit 클래스 - 유닛의 현재 HP와 위치를 나타내는 멤버 변수를 가짐
class Unit {
    int currentHP; // 유닛의 현재 체력
    int x;         // 유닛의 위치(x 좌표)
    int y;         // 유닛의 위치(y 좌표)
}

// Fightable 인터페이스 - Movable 인터페이스와 Attackable 인터페이스를 상속받음
interface Fightable extends Movable, Attackable { }

// Movable 인터페이스 - 이동 기능을 나타내는 추상 메서드를 가짐
interface Movable {
    void move(int x, int y); // 지정한 좌표로 이동하는 메서드(구현은 해당 인터페이스를 구현한 클래스에서 이루어짐)
}

// Attackable 인터페이스 - 공격 기능을 나타내는 추상 메서드를 가짐
interface Attackable {
    void attack(Unit u); // 지정한 유닛을 공격하는 메서드(구현은 해당 인터페이스를 구현한 클래스에서 이루어짐)
}

