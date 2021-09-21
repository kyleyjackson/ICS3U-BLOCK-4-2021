package week3;

public class MathClassExamples {
    public static void main(String[] args) {
        System.out.println(Math.abs(-4)); // *Math.abs() returns the absolute value of an int
        System.out.println(Math.abs(-4.1)); // *Every method in the math class is static

        System.out.println(Math.pow(2, 3)); // *Two to the power of three

        // *Length of a line segment between two points

        int x1 = 5;
        int y1 = 3;
        int x2 = 10;
        int y2 = 2;

        double lengthOfLineSegment = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        System.out.println(lengthOfLineSegment);
    }
}
