package example;

@FunctionalInterface
interface MyFunction {
	void myMethod();  // 추상 메서드 하나를 가진 함수형 인터페이스
}

class LambdaEx3 {
	public static void main(String args[]) {
		Outer outer = new Outer();  // Outer 객체 생성
		Outer.Inner inner = outer.new Inner();  // Outer의 내부 클래스 Inner 객체 생성
		inner.method(100);  // Inner의 method 호출
	}
}

class Outer {
	int val = 10;  // Outer 객체의 val

	class Inner {
		int val = 20;  // Inner 객체의 val

		void method(int i) {
			int val = 30;  // 메서드 내의 지역 변수 val (상수로 선언됨)

			MyFunction f = () -> {
				System.out.println("i                : " + i);              // 람다식 내에서 매개변수 i 사용
				System.out.println("val              : " + val);            // 람다식 내에서 지역 변수 val 사용 (상수)
				System.out.println("this.val         : " + this.val);       // 람다식 내에서 Inner 객체의 val 사용
				System.out.println("Outer.this.val   : " + Outer.this.val); // 람다식 내에서 Outer 객체의 val 사용
			};

			f.myMethod();  // 람다식 실행
		}
	}
}
