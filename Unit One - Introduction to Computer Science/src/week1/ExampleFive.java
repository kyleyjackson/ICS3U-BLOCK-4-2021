package week1;

/**
 * Mixing int and double might not work too well Can divide integers into
 * doubles by adding decimal
 */
public class ExampleFive {
    public static void main(String[] args) {
        int markOne = 75, markTwo = 80, markThree = 87;
        double average = (markOne + markTwo + markThree) / 3.0; // 242 / 3 = 80, unless you fix it by adding decimal
                                                                // places, or by changing ints to doubles

        System.out.println("The average is: " + average);

        // Interger vs. Double Division
        System.out.println(4 / 5); // 0
        System.out.println(4.0 / 5);// 0.8
        System.out.println(5 / 4); // 1
        System.out.println(5.0 / 4);// 1.25

        // Modulus Operator "%" => Gives the remainder of a divison equation
        System.out.println(13 / 3); // 13 divided by 3 => 4 (since this is integer division)
        System.out.println(13 % 3); // 13 mod 3 => 1
    }
}
