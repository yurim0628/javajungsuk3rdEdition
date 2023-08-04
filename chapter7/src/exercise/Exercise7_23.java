package exercise;

import exercise.Shape;
import exercise.Rectangle;
import exercise.Circle;

class Exercise7_23 {
    static double sumArea(Shape[] arr) {
        double sum = 0.0d;
        for (int i=0; i<arr.length; i++) {
            sum += arr[i].calcArea();
        }
        return sum;
    }

    public static void main(String args[]) {
        Shape[] arr = {new Circle(5.0), new Rectangle(3,4), new Circle(1)};
        System.out.println("면적의 합 : " + sumArea(arr));
    }
}

