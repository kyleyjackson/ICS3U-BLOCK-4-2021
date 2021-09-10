package week1;

/**
 * Escape Sequences
 */
public class ExampleThree {
    public static void main(String[] args) {
        // System.out.println("This is "very" important!"); Double quotes encapsulate
        // the string literal - putting a quote in a string literal gets Java upset
        System.out.println("This is \"very\" important!"); // Backslash escapes a character (allows it to be in the
                                                           // string literal)
        System.out.println("This is very \\important!"); // Displays: This is very \important!

        System.out.println("This\nis\nvery\nimportant!"); // \n is new line
    }
}
