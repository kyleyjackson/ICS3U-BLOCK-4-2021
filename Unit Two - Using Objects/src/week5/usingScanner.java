package week5;

import java.util.Scanner;

public class usingScanner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // exampleOne(in);
        exampleTwo(in);
        in.close();
    }

    private static void exampleOne(Scanner in) {
        System.out.print("Please enter your name: ");
        String name = in.nextLine();

        System.out.println("Hello " + name + ".");

    }

    private static void exampleTwo(Scanner in) {
        System.out.print("please enter a number: ");
        // double num = in.nextDouble();

        double num = 0;

        boolean validInput = false;

        while (!validInput) {
            try {
                num = Double.parseDouble(in.nextLine());
                validInput = true;
            } catch (Exception ex) {
                System.out.print("Please enter something valid, try again: ");
            }
        }

        double result = Math.pow(num, 2);
        System.out.println(result);
    }
}
