package example;

final class Singleton {
    private static Singleton s = new Singleton(); // 정적 필드로 단일 인스턴스를 생성

    private Singleton() {
        // private 생성자로 외부에서의 인스턴스 생성을 막음
        //...
    }

    public static Singleton getInstance() {
        if (s == null) {
            // 단일 인스턴스가 아직 생성되지 않은 경우에만 생성
            s = new Singleton();
        }
        return s;
    }

    //...
}

class SingletonTest {
    public static void main(String args[]) {
//		Singleton s = new Singleton(); // 오류 발생: 생성자가 private으로 선언되어 외부에서의 인스턴스 생성 불가
        Singleton s = Singleton.getInstance(); // getInstance 메서드를 통해 단일 인스턴스를 가져옴
    }
}

