package example;

class Product {
    static int count = 0;   // 생성된 인스턴스의 수를 저장하기 위한 변수
    /* 만일 count변수를 인스턴스변수로 선언했다면, 인스턴스가 생성될 때마다 0으로 초기화 될것이므로
    모든 Product인스턴스의 SerialNo값은 항상 1이 될 것이다. */
    int serialNo;	        // 인스턴스 고유의 번호

    {
        ++count;
        serialNo = count;
    }
    /* Product인스턴스가 생성될 때마다 count의 값을 1씩 증가시켜서 serialNo에 저장한다.
    새로 생성되는 인스턴스는 이전에 생성된 인스턴스보다 1이 증가된 serialNo값을 갖게 된다. */

    public Product() {}     // 기본생성자, 생략가능
}

class ProductTest {
    public static void main(String args[]) {
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();

        System.out.println("p1의 제품번호(serial no)는 " + p1.serialNo);
        System.out.println("p2의 제품번호(serial no)는 " + p2.serialNo);
        System.out.println("p3의 제품번호(serial no)는 " + p3.serialNo);
        System.out.println("생산된 제품의 수는 모두 "+Product.count+"개 입니다.");
    }
}
