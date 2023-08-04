package example;

class VarArgsEx {
    public static void main(String[] args) {
        String[] strArr = { "100", "200", "300" };

        System.out.println(concatenate("", "100", "200", "300"));  // 출력: 100200300
        System.out.println(concatenate("-", strArr));              // 출력: 100-200-300
        System.out.println(concatenate(",", new String[]{"1", "2", "3"}));  // 출력: 1,2,3
        System.out.println("[" + concatenate(",", new String[0]) + "]");    // 출력: []
        System.out.println("[" + concatenate(",") + "]");                    // 출력: ""

    }
    /* 아래와 같은 문장은 허용되지 않는다.
    System.out.println(concatenate("", {"100", "200", "300"}))
    배열 초기화 구문을 사용하여 배열을 선언하거나 초기화할 수 있지만, 메서드 호출 시에는 직접 생성한 배열을 인수로 전달해야 한다. */

    static String concatenate(String delim, String... args) {
        String result = "";

        for(String str : args) {
            result += str + delim;
        }

        return result;
    }

/*
	static String concatenate(String... args) {
		return concatenate("",args);
	}
*/
    /* 주석을 풀고 컴파일을 하면 두 오버로딩 된 메서드가 구분되지 않아서 컴파일에러가 발생한다. */
}
