package exercise;

class Exercise6_19 {
    public static void change(String str) {
        str += "456";
        /* 새로운 문자열을 생성하여 변경한 것이므로, 메서드 외부의 변수에는 영향을 주지 않는다. */
    }

    public static void main(String[] args) {
        String str = "ABC123";
        System.out.println(str); // "ABC123" 출력

        change(str); // change 메서드 호출 (인자로 str 전달)

        System.out.println("After change:" + str); // "After change: ABC123" 출력
    }
}

