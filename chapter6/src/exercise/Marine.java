package exercise;

public class Marine {
    int x = 0, y = 0; // Marine의 위치좌표(x,y)
    int hp = 60; // 현재 체력
    static int weapon = 6; // 공격력 (클래스변수)
    static int armor = 0; // 방어력 (클래스변수)
    /* 인스턴스마다 독립적인 값을 가지지 않고 클래스 전체에서 공유하도록 한다. */

    void weaponUp() {
        weapon++;
    }

    void armorUp() {
        armor++;
    }

    void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

