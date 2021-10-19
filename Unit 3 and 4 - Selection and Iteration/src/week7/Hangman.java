package week7;

import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        boolean playAgain = true;
        Scanner in = new Scanner(System.in);

        while (playAgain) {
            play("READY TO USE SURFACE CLEANER", in);
            playAgain = playAgain(in);
        }
    }

    private static boolean playAgain(Scanner in) {
        boolean validInput = false;

        while (validInput) {
            System.out.print("Do you wish to play again? Y/N: ");
            String answer = in.nextLine().toUpperCase();
            if (answer.equals("Y")) {
                return true;
            } else if (answer.equals("N")) {
                return false;
            } else {
                System.out.println("Invalid Input.");
            }
        }
        return false;
    }

    // * _ _ _ _ _ | _ _ | _ _ _ | _ _ _ _ _ _ _ | _ _ _ _ _ _ _ |

    /**
     * 
     ** O /|\ /\
     */
    private static void play(String str, Scanner in) {
        boolean gameOver = false;
        String usedChars = "";
        String availableChars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
        int numPieces = 0;

        while (!gameOver) {
            String encryptedHint = encryptHint(str, usedChars);
            System.out.println(encryptedHint);

            String letter = getLetter(availableChars, in);

            if (str.indexOf(letter) < 0) {
                numPieces++;
            }

            usedChars += letter;
            availableChars = availableChars.replace(letter, "_");
            drawHangman(numPieces);

            if (numPieces == 7) {
                gameOver = true;
                System.out.println("You lost.");
            } else if (encryptHint(str, usedChars).indexOf("_") < 0) {
                gameOver = true;
                System.out.println("You won.");
            }
        }
    }

    private static void drawHangman(int numPieces) {
        if (numPieces == 6) {
            System.out.println("  _________________");
            System.out.println("  |               |");
            System.out.println("  |               |");
            System.out.println("  |               O");
            System.out.println("  |              /|\\");
            System.out.println("  |              / \\");
            System.out.println("  |");
            System.out.println("__|__");

        } else if (numPieces == 5) {
            System.out.println("  _________________");
            System.out.println("  |               |");
            System.out.println("  |               |");
            System.out.println("  |               O");
            System.out.println("  |              /|\\");
            System.out.println("  |              /");
            System.out.println("  |");
            System.out.println("__|__");

        } else if (numPieces == 4) {
            System.out.println("  _________________");
            System.out.println("  |               |");
            System.out.println("  |               |");
            System.out.println("  |               O");
            System.out.println("  |              /|\\");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("__|__");

        } else if (numPieces == 3) {
            System.out.println("  _________________");
            System.out.println("  |               |");
            System.out.println("  |               |");
            System.out.println("  |               O");
            System.out.println("  |              /|");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("__|__");

        } else if (numPieces == 2) {
            System.out.println("  _________________");
            System.out.println("  |               |");
            System.out.println("  |               |");
            System.out.println("  |               O");
            System.out.println("  |               |");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("__|__");

        } else if (numPieces == 1) {
            System.out.println("  _________________");
            System.out.println("  |               |");
            System.out.println("  |               |");
            System.out.println("  |               O");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("__|__");

        } else if (numPieces == 0) {
            System.out.println("  _________________");
            System.out.println("  |               |");
            System.out.println("  |               |");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("__|__");

        }
    }

    private static String getLetter(String availableChars, Scanner in) {
        boolean validInput = false;
        String letter = " ";

        while (!validInput) {
            System.out.println("Available Letters:\n" + availableChars + "\n");
            letter = in.nextLine().toUpperCase();
            if (letter.length() == 1 && "_ ".indexOf(letter) <= 0 && availableChars.indexOf(letter) >= 0)

                if (availableChars.indexOf(letter) >= 0) {
                    validInput = true;
                } else {
                    System.out.println("Invalid Input.");
                }
        }
        return letter;
    }

    private static String encryptHint(String str, String usedChars) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            String temp = str.substring(i, i + 1);

            if (temp.equals(" ")) {
                result += "| ";
            } else if (usedChars.indexOf(temp) >= 0) {
                result += temp + " ";
            } else {
                result += "_ ";
            }
        }
        return result;
    }
}