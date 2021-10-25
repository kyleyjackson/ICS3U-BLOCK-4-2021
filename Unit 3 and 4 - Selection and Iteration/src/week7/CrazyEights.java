package week7;

import java.util.Scanner;

public class CrazyEights {
    private static final int NUM_SUITS = 4;
    private static final double CARDS_PER_SUIT = 13;
    private static final String HEARTS = "H";
    private static final String DIAMONDS = "D";
    private static final String CLUBS = "C";
    private static final String SPADES = "S";
    private static final String ACE = "1";
    private static final String TWO = "2";
    private static final String THREE = "3";
    private static final String FOUR = "4";
    private static final String FIVE = "5";
    private static final String SIX = "6";
    private static final String SEVEN = "7";
    private static final String EIGHT = "50";
    private static final String NINE = "9";
    private static final String KING = "10";
    private static final String QUEEN = "10";
    private static final String JACK = "10";
    private static final String TEN = "10";
    private static final int PLAYER_WINS = 1;
    private static final int COMPUTER1_WINS = 2;
    private static final int COMPUTER2_WINS = 3;
    private static final int TIE = 4;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int playerPoints = 0;
        int c1Points = 0;
        int c2Points = 0;

        playCrazyEights(in, playerPoints, c1Points, c2Points);
    }

    private static int playCrazyEights(Scanner in, int playerPoints, int c1Points, int c2Points) {
        String playerHand = "";
        String computer1Hand = "";
        String computer2Hand = "";
        String topCard = "";
        boolean validInput = false;

        playerHand = getCard() + " ";
        playerHand += getCard() + " ";
        playerHand += getCard() + " ";
        playerHand += getCard() + " ";
        playerHand += getCard() + " ";

        computer1Hand = getCard() + " ";
        computer1Hand += getCard() + " ";
        computer1Hand += getCard() + " ";
        computer1Hand += getCard() + " ";
        computer1Hand += getCard() + " ";

        computer2Hand = getCard() + " ";
        computer2Hand += getCard() + " ";
        computer2Hand += getCard() + " ";
        computer2Hand += getCard() + " ";
        computer2Hand += getCard() + " ";

        // continueGame(in, playerPoints, c1Points, c2Points, playerHand, computer1Hand,
        // computer2Hand, topCard);
        while (!gameOver(playerPoints, c1Points, c2Points)) {
            String result = playRound(in, playerHand, computer1Hand, computer2Hand, topCard);
            int firstDash = result.indexOf("-");
            int secondDash = result.lastIndexOf("-");
            playerPoints += Integer.parseInt(result.substring(0, firstDash));
            c1Points += Integer.parseInt(result.substring(firstDash + 1, secondDash));
            c2Points += Integer.parseInt(result.substring(secondDash + 1));
        }
        return getWinner(playerPoints, c1Points, c2Points);
    }

    private static int getWinner(int playerPoints, int c1Points, int c2Points) {
        return 0;
    }

    private static boolean gameOver(int playerPoints, int c1Points, int c2Points) {
        return playerPoints >= 100 || c1Points >= 100 || c2Points >= 100;
    }

    private static String playRound(Scanner in, String playerHand, String c1Hand, String c2Hand, String topCard) {
        // *hand-topCard

        topCard = getCard();
        System.out.println("The top card is: " + topCard);

        while (playerHand.isBlank() == false || playerHand.isBlank() == false || playerHand.isBlank() == false) {

            String temp = processPlayer(in, playerHand, topCard);
            playerHand = temp.substring(0, temp.indexOf("-"));
            topCard = temp.substring(temp.indexOf("-") + 1);
            /*
             * temp = processComputerOne(c1Hand, topCard, playerHand, c2Hand); c1Hand =
             * temp.substring(0, temp.indexOf("-")); topCard =
             * temp.substring(temp.indexOf("-"));
             * 
             * temp = processComputerTwo(c2Hand, topCard, playerHand, c2Hand); c2Hand =
             * temp.substring(0, temp.indexOf("-")); topCard =
             * temp.substring(temp.indexOf("-"));
             */
        }
        return "";
    }

    /**
     * *If computer has a card of the same suit it plays that first
     * 
     * *Else if they have a card of same rank it plays that 
     * 
     * *Else if they have an eight they play that
     * *They will choose a suit in their hand (Math.random())
     * *If another player has one card left, they will swap the suit if they can (probably check this first)
     */
    private static String processComputerOne(String c1Hand, String topCard, String playerHand, String c2Hand) {
        if((playerHand.length() < 5 || c2Hand.length() < 5) && c1Hand.indexOf("8") >= 0) {
                
        }else if() {

        }else if() {

        }
        return null;
    }

    private static String processComputerTwo(String c1Hand, String topCard, String playerHand, String c2Hand) {
        if(playerHand.length() < 5 || c1Hand.length() < 5) {
            
        }else if() {

        }else if() {

        }
        return null;
    }

    private static String processPlayer(Scanner in, String playerHand, String topCard) {
        boolean validInput = false;

        while (!validInput) {
            if (checkFace(playerHand, topCard) == true || checkSuit(playerHand, topCard) == true
                    || playerHand.indexOf("8") >= 0) {
                System.out.println("\n-----------------------------------------------------------\n");
                System.out.print("What card would you like to play (" + playerHand.trim() + "): ");
                String card = in.nextLine().toUpperCase();
                System.out.println("\n-----------------------------------------------------------\n");
                if (validateCard(card) == false) {
                    System.out.println("Invalid Input!");
                    System.out.println("\n-----------------------------------------------------------\n");
                    System.out.println("Your hand is: " + playerHand);
                    System.out.println("The top card is: " + topCard);
                    System.out.println("\n-----------------------------------------------------------\n");
                } else if (card.indexOf("8") >= 0) {
                    System.out.print("Enter new suit (Hearts, Diamonds, Spades, Clubs): ");
                    String newSuit = in.nextLine().toUpperCase();
                    System.out.println("\n-----------------------------------------------------------\n");
                    if (newSuit.equals("HEARTS") || newSuit.equals("CLUBS") || newSuit.equals("DIAMONDS")
                            || newSuit.equals("SPADES")) {
                        if (newSuit.equals("HEARTS")) {
                            topCard = "8H";
                            playerHand = playerHand.replaceFirst(card, "");
                            validInput = true;
                            System.out.println("The new suit is: " + newSuit);
                            System.out.println("\n-----------------------------------------------------------\n");
                        } else if (newSuit.equals("DIAMONDS")) {
                            topCard = "8D";
                            playerHand = playerHand.replaceFirst(card, "");
                            validInput = true;
                            System.out.println("The new suit is: " + newSuit);
                            System.out.println("\n-----------------------------------------------------------\n");
                        } else if (newSuit.equals("CLUBS")) {
                            topCard = "8C";
                            playerHand = playerHand.replaceFirst(card, "");
                            validInput = true;
                            System.out.println("The new suit is: " + newSuit);
                            System.out.println("\n-----------------------------------------------------------\n");
                        } else {
                            topCard = "8S";
                            playerHand = playerHand.replaceFirst(card, "");
                            validInput = true;
                            System.out.println("The new suit is: " + newSuit);
                            System.out.println("\n-----------------------------------------------------------\n");
                        }
                    } else {
                        System.out.println("Invalid Input!");
                        System.out.println("\n-----------------------------------------------------------\n");
                        System.out.println("Enter new suit (Hearts, Diamonds, Spades, Clubs): ");
                        System.out.println("\n-----------------------------------------------------------\n");
                    }
                } else if (playerHand.indexOf(card) >= 0) {
                    topCard = card;
                    playerHand = playerHand.replaceFirst(card, "");
                    validInput = true;
                    System.out.println("\n-----------------------------------------------------------\n");
                    System.out.println("The top card is: " + topCard);
                    System.out.println("\n-----------------------------------------------------------\n");
                }
            } else if (checkFace(playerHand, topCard) == false || checkSuit(playerHand, topCard) == false) {
                System.out.println("You can't play!");
                playerHand = " " + drawCard(playerHand, topCard);
                validInput = true;
                System.out.println("The top card is: " + topCard);
                System.out.println("\n-----------------------------------------------------------\n");
            }
        }
        return playerHand.trim() + "-" + topCard;
    }

    private static String drawCard(String playerHand, String topCard) {
        boolean gotCard = false;
        System.out.println("\n-----------------------------------------------------------\n");
        while (!gotCard) {
            String newCard = getCard();
            if (checkFace(playerHand, topCard) == true || checkSuit(playerHand, topCard) == true
                    || newCard.indexOf("8") >= 0) {
                gotCard = true;
            } else {
                playerHand += newCard + " ";
                System.out.println("You drew a " + newCard);
            }

        }
        System.out.println("\n-----------------------------------------------------------\n");
        return playerHand;
    }

    private static boolean checkFace(String playerHand, String topCard) {
        if (topCard.trim().length() == 3) {
            return playerHand.contains(topCard.substring(0, 2));
        } else {
            return playerHand.contains(topCard.substring(0, 1));
        }
    }

    private static boolean checkSuit(String playerHand, String topCard) {
        return playerHand.contains(topCard.substring(topCard.length() - 1, topCard.length()));
    }

    private static boolean validateCard(String card) {
        if (card.equals("AH") || card.equals("AC") || card.equals("AD") || card.equals("AS")) {
            return true;
        } else if (card.equals("2H") || card.equals("2C") || card.equals("2D") || card.equals("2S")) {
            return true;
        } else if (card.equals("3H") || card.equals("3C") || card.equals("3D") || card.equals("3S")) {
            return true;
        } else if (card.equals("4H") || card.equals("4C") || card.equals("4D") || card.equals("4S")) {
            return true;
        } else if (card.equals("5H") || card.equals("5C") || card.equals("5D") || card.equals("5S")) {
            return true;
        } else if (card.equals("6H") || card.equals("6C") || card.equals("6D") || card.equals("6S")) {
            return true;
        } else if (card.equals("7H") || card.equals("7C") || card.equals("7D") || card.equals("7S")) {
            return true;
        } else if (card.equals("8H") || card.equals("8C") || card.equals("8D") || card.equals("8S")) {
            return true;
        } else if (card.equals("9H") || card.equals("9C") || card.equals("9D") || card.equals("9S")) {
            return true;
        } else if (card.equals("10H") || card.equals("10C") || card.equals("10D") || card.equals("10S")) {
            return true;
        } else if (card.equals("JH") || card.equals("JC") || card.equals("JD") || card.equals("JS")) {
            return true;
        } else if (card.equals("QH") || card.equals("QC") || card.equals("QD") || card.equals("QS")) {
            return true;
        } else if (card.equals("KH") || card.equals("KC") || card.equals("KD") || card.equals("KS")) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean playAgain(Scanner in) {
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Do you want to play again ([Y]es / [N]o): ");
            String answer = in.nextLine().toUpperCase();
            if (answer.equals("YES") || answer.equals("Y"))
                return true;
            else if (answer.equals("NO") || answer.equals("N")) {
                return false;
            } else {
                System.out.println("Invalid Input: Yes or No only!");
            }
        }

        return false;
    }

    private static String getCard() {
        String card = getFace() + getSuit();

        return card;
    }

    private static String getSuit() {
        int suit = (int) (Math.random() * NUM_SUITS);

        if (suit == 0)
            return HEARTS;
        else if (suit == 1)
            return DIAMONDS;
        else if (suit == 2)
            return CLUBS;
        else
            return SPADES;
    }

    private static String getFace() {
        int suit = (int) (Math.random() * CARDS_PER_SUIT);
        if (suit >= 2 && suit <= 10)
            return suit + "";
        else if (suit == 1)
            return ACE;
        else if (suit == 11)
            return JACK;
        else if (suit == 12)
            return QUEEN;
        else
            return KING;
    }
}