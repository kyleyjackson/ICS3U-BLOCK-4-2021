package week5;

public class FormattingStrings {
    public static void main(String[] args) {
        int minutes = 5;
        double seconds = 7.545474;

        System.out.println(minutes + ":" + seconds);

        /**
         * Placeholders %d => ints %s => strings %f => doubles
         */
        System.out.printf("d:%.3f", minutes, seconds);
    }
}
