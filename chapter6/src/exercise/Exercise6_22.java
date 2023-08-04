package exercise;

class Exercise6_22 {
    static boolean isNumber(String str) {
        // 주어진 문자열의 각 문자를 순회하며 검사
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // 숫자가 아닌 문자가 발견되면 false를 반환
            if (ch < '0' || ch > '9') {
                return false;
            }
        }
        // 모든 문자가 숫자인 경우 true를 반환
        return true;
    }

    public static void main(String[] args) {
        String str = "123";
        // isNumber 메서드를 호출하여 숫자인지 여부를 확인하고 결과를 출력
        System.out.println(str + "는 숫자입니까? " + isNumber(str));

        str = "1234o";
        // isNumber 메서드를 호출하여 숫자인지 여부를 확인하고 결과를 출력
        System.out.println(str + "는 숫자입니까? " + isNumber(str));
    }
}
