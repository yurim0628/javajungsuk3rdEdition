package example;

import static java.lang.System.out; // System 클래스의 static 멤버인 out을 직접 사용하겠다는 선언
import static java.lang.Math.*;    // Math 클래스의 모든 static 멤버들을 직접 사용하겠다는 선언

class StaticImportEx1 {
    public static void main(String[] args) {
        // System.out.println(Math.random());
        out.println(random());

        // System.out.println("Math.PI :"+Math.PI);
        out.println("Math.PI :" + PI);
    }
}

