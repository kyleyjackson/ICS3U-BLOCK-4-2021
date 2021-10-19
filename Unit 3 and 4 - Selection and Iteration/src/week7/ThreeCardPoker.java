package week7;

import java.util.Scanner;

public class ThreeCardPoker {
    private static final double NUM_SUITS = 4;
    private static final double NUM_FACES = 13;
    private static final String HEARTS = "H";
    private static final String DIAMONDS = "D";
    private static final String SPADES = "S";
    private static final String CLUBS = "C";
    private static final String ACE = "A";
    private static final String KING = "K";
    private static final String JACK = "J";
    private static final String QUEEN = "Q";

    public static void main(String[] args) {
        int balance = 500;
        Scanner in = new Scanner(System.in);
        String currentHand = "";

        // int wager = getWager(in, 50, 100, balance);
        // System.out.print(wager);

        currentHand = getCard(currentHand) + " ";
        currentHand += getCard(currentHand) + " ";
        currentHand += getCard(currentHand) + " ";
        System.out.println(currentHand);

        currentHand = discard(in, currentHand);
        System.out.println(currentHand);
    }
    /*
     * First bet (ante) $50 - $100 If the player doesn't have a pair, face card or
     * ace, they fold Three cards dealt face down to player Player can look at
     * cards, and choose to replace + make a new wager ($50 - $100) Before making
     * 2nd wager, player can replace 1 - 3 cards If the player folds, dealer
     * collects the player's wager If the player places a play wager, the cards will
     * be turned over If the dealer's hand is superior, both ante and play bets are
     * collected Only using 1 deck of cards
     */

    private static String discard(Scanner in, String currentHand) {
        boolean validInput = false;
        System.out.print("Enter the amount of cards you wish to replace: ");
        int numDiscard = Integer.parseInt(in.nextLine());
        while (!validInput) {
            if (numDiscard == 0) {
                return currentHand;
            } else if (numDiscard == 1) {
                System.out.print("Please enter the card to replace: ");
                String replace = in.nextLine();
                if (currentHand.indexOf(replace) < 0) {
                    System.out.println("Please enter a card in your hand");
                } else {
                    currentHand = currentHand.substring(0, currentHand.indexOf(replace));
                    currentHand += getCard(currentHand);
                    break;
                }
            } else if (numDiscard == 2) {
                System.out.print("Please enter the cards to replace (with spaces in between): ");
                String replace = in.nextLine();
            } else if (numDiscard == 3) {
                currentHand = "";
                currentHand += getCard(currentHand) + " " + getCard(currentHand) + " " + getCard(currentHand);
            } else {
                System.out.println("Please enter a valid amount of cards (1 - 3)");
                validInput = true;
            }
        }
        return currentHand;
    }

    private static String getCard(String usedCards) {
        String card = getFace() + getSuit();
        if (usedCards.indexOf(card) > 0) {
            return getFace() + getSuit();
        } else {
            return card;
        }

    }

    private static String getSuit() {
        int suit = (int) (Math.random() * NUM_SUITS);

        if (suit == 0) {
            return HEARTS;
        } else if (suit == 1) {
            return DIAMONDS;
        } else if (suit == 2) {
            return SPADES;
        } else {
            return CLUBS;
        }
    }

    private static String getFace() {
        int face = (int) (Math.random() * NUM_FACES);

        if (face >= 2 && face <= 10) {
            return "" + face;
        } else if (face == 1) {
            return ACE;
        } else if (face == 11) {
            return JACK;
        } else if (face == 12) {
            return QUEEN;
        } else {
            return KING;
        }
    }

    private static int getWager(Scanner in, int min, int max, int balance) {
        boolean validInput = false;
        int wager = 0;

        while (!validInput) {
            System.out.print("Input your wager ($50 - $100): ");
            try {
                wager = Integer.parseInt(in.nextLine());

                if (wager > balance) {
                    System.out.println("You don't have enough money, your current balance is: $" + balance + ".");
                } else if (wager < min || wager > max) {
                    System.out.println("Your wager must be in between $" + min + " and $" + max + ".");
                } else {
                    validInput = true;
                }
            } catch (Exception ex) {
                System.out.println("Invalid Input, please input a non-decimal number");
            }
        }
        return wager;
    }
}