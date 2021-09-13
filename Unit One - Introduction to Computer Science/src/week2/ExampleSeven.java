package week2;

/**
 * final modifier - makes a value constant
 */
public class ExampleSeven {
    public static void main(String[] args) {
        final int x = 7;
        // x = 6; - cannot reassign a value to a final variable

        final int y;
        y = 8;
        // y++; - cannot modify the variable onceit is set if it is constant

        final int NUM_STUDENTS = 18; // use all caps and underscores to differentiate words for constant variables

    }
}
