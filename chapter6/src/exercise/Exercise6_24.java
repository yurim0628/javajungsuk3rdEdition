package exercise;

class Exercise6_24
{
    static int abs(int value){
        return Math.abs(value);
    }
    public static void main(String[] args){
        int value = 5;
        System.out.println(value+"의 절대값:"+abs(value));
        value = -10;
        System.out.println(value+"의 절대값:"+abs(value));
    }
}
