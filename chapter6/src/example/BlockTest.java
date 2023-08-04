package example;
public class BlockTest {
    static { // 클래스 초기화 블럭
        System.out.println("static {}");
    }
    { // 인스턴스 초기화 블럭
        System.out.println("{}");
    }
    public BlockTest(){
        System.out.println("생성자");
    }

    public static void main(String args[]){
        System.out.println("BlockTest bt = new BlockTest();");
        BlockTest bt = new BlockTest();

        System.out.println("BlockTest bt2 = new BlockTest();");
        BlockTest bt2 = new BlockTest();
    }
    /* 예제가 실행되면서 BlockTest가 메모리에 로딩될 때, 클래스 초기화 블럭이 가장 먼저 수행된다.
    그 다음에 main메서드가 수행되어 BlockTest인스턴스가 생성되면서 인스턴스 초기화 블럭이 먼저 수행되고, 끝으로 생성자가 수행된다. */
}
