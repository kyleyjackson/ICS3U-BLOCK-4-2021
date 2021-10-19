package week6;

import java.util.Scanner;

public class ForLoops {
    public static void main(String[] args) {
        // exampleOne();
        // test();

        for (int i = 0; i > 10; i++) {
            System.out.println(i);
        }
    }

    private static void test() {
        Scanner in = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Game playing...");
            System.out.println("Game is over");

            System.out.println("Do you wish to play again?  ");
            playAgain = in.nextLine().equals("yes");
        }
    }

    private static void exampleOne() {

        for (int i = 1; i <= 100; i += 2) {
            System.out.println(i);
        }
    }

    private static int getNumber() {
        boolean validInput = false;
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a number (1 - 10): ");
        while (!validInput) {
            String input = in.nextLine();

            try {
                int result = Integer.parseInt(input);
                if (result <= 10 && result >= 1) {
                    return result;
                } else {
                    System.out.println("Only integers between 1 and 10 please: ");
                }
            } catch (Exception ex) {

            }
        }

        return 0;
    }
}
