package week7;

import java.util.Scanner;

public class CrazyEights {
    private static final int NUM_SUITS = 4;
    private static final double CARDS_PER_SUIT = 13;
    private static final String HEARTS = "H";
    private static final String DIAMONDS = "D";
    private static final String CLUBS = "C";
    private static final String SPADES = "S";
    private static final int ACE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int SEVEN = 7;
    private static final int EIGHT = 50;
    private static final int NINE = 9;
    private static final int KING = 10;
    private static final int QUEEN = 10;
    private static final int JACK = 10;
    private static final int TEN = 10;
    private static final int PLAYER_WINS = 1;
    private static final int COMPUTER1_WINS = 2;
    private static final int COMPUTER2_WINS = 3;
    private static final int TIE = 4;
    private static final String ACE_FACE = "A";
    private static final String KING_FACE = "K";
    private static final String QUEEN_FACE = "Q";
    private static final String JACK_FACE = "J";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int playerPoints = 0;
        int c1Points = 0;
        int c2Points = 0;

        int winner = playCrazyEights(in, playerPoints, c1Points, c2Points);
        
        if(winner == 1) {
            System.out.println("PLAYER WINS!!!");
        }else if(winner == 2) {
            System.out.println("COMPUTER ONE WINS!!!");
        }else if(winner == 3) {
            System.out.println("COMPUTER TWO WINS!!!");
        }else if(winner == 4) {
            System.out.println("TIE!!!");
        }
        
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
        if(playerPoints < c1Points && playerPoints < c2Points) {
            return PLAYER_WINS;
        }else if(c1Points < playerPoints && c1Points < c2Points) {
            return COMPUTER1_WINS;
        }else if(c2Points < playerPoints && c2Points < c1Points) {
            return COMPUTER2_WINS;
        }else {
            return TIE;
        }
    }

    private static boolean gameOver(int playerPoints, int c1Points, int c2Points) {
        return playerPoints >= 100 || c1Points >= 100 || c2Points >= 100;
    }

    private static String playRound(Scanner in, String playerHand, String c1Hand, String c2Hand, String topCard) {
        // *hand-topCard

        topCard = getCard();
        if (topCard.substring(0, 1).equals("8")) {
            topCard = getCard();
        } else {
            System.out.println("The top card is: " + topCard);
        }

        while (playerHand.isBlank() == false || c1Hand.isBlank() == false || c2Hand.isBlank() == false) {    
            System.out.println("\n-----------------------------------------------------------\n");
            System.out.println("Your hand is: " + playerHand);
            System.out.println("Computer 1 hand is: " + c1Hand);
            System.out.println("Computer 2 hand is: " + c2Hand);
            System.out.println("\n-----------------------------------------------------------\n");

            String temp = processPlayer(in, playerHand, topCard);
            playerHand = temp.substring(0, temp.indexOf("-"));
            topCard = temp.substring(temp.indexOf("-") + 1);

            temp = processComputer(c1Hand, topCard, playerHand, c2Hand);
            c1Hand = temp.substring(0, temp.indexOf("-"));
            topCard = temp.substring(temp.indexOf("-") + 1);

            temp = processComputer(c2Hand, topCard, playerHand, c1Hand);
            c2Hand = temp.substring(0, temp.indexOf("-"));
            topCard = temp.substring(temp.indexOf("-") + 1);
        }
        String points = calculatePoints(playerHand, c1Hand, c2Hand);
        String playerPoints = points.substring(0, points.indexOf("-"));
        String c1Points = points.substring(points.indexOf("-") + 1, points.indexOf("*"));
        String c2Points = points.substring(points.indexOf("*") + 1);
        System.out.println("Player Points: " + playerPoints + " Computer 1 Points: " + c1Points + " Computer 2 Points: " + c2Points);
        return points;
    }

    private static boolean checkIfBlank(String str) {
        String noSpaceStr = str.replaceAll("\\s", "");

        if(noSpaceStr.equals("")) {
            return true;
        }else {
            return false;
        }
    }

    private static String calculatePoints(String playerHand, String c1Hand, String c2Hand) {
        int playerPoints = 0;
        int c1Points = 0;
        int c2Points = 0;

        if(checkIfBlank(playerHand) == true) {
            playerPoints = 0;
        }else {
            for (int i = 0; i < playerHand.length(); i++) {
                String temp = playerHand.substring(i, i + 1);
                if (temp.equals("A")) {
                    playerPoints += ACE;
                }else if(temp.equals("2")) {
                    playerPoints += TWO;
                }else if(temp.equals("3")) {
                    playerPoints += THREE;    
                }else if(temp.equals("4")) {
                    playerPoints += FOUR;
                }else if(temp.equals("5")) {
                    playerPoints += FIVE;
                }else if(temp.equals("6")) {
                    playerPoints += SIX;
                }else if(temp.equals("7")) {
                    playerPoints += SEVEN;
                }else if(temp.equals("8")) {
                    playerPoints += EIGHT;
                }else if(temp.equals("9")) {
                    playerPoints += NINE;
                }else if(temp.equals("10")) {
                    playerPoints += TEN;
                }else if(temp.equals("J")) {
                    playerPoints += JACK;
                }else if(temp.equals("Q")) {
                    playerPoints += QUEEN;
                }else if(temp.equals("K")) {
                    playerPoints += KING;
                }else {
                    playerPoints += 0;
                }
            }
        }
        
        if(checkIfBlank(c1Hand) == true) {
            c1Points = 0;
        }else {
            for (int i = 0; i < c1Hand.length(); i++) {
                String temp = c1Hand.substring(i, i + 1);
                if (temp.equals("A")) {
                    c1Points += ACE;
                }else if(temp.equals("2")) {
                    c1Points += TWO;
                }else if(temp.equals("3")) {
                    c1Points += THREE;    
                }else if(temp.equals("4")) {
                    c1Points += FOUR;
                }else if(temp.equals("5")) {
                    c1Points += FIVE;
                }else if(temp.equals("6")) {
                    c1Points += SIX;
                }else if(temp.equals("7")) {
                    c1Points += SEVEN;
                }else if(temp.equals("8")) {
                    c1Points += EIGHT;
                }else if(temp.equals("9")) {
                    c1Points += NINE;
                }else if(temp.equals("10")) {
                    c1Points += TEN;
                }else if(temp.equals("J")) {
                    c1Points += JACK;
                }else if(temp.equals("Q")) {
                    c1Points += QUEEN;
                }else if(temp.equals("K")) {
                    c1Points += KING;
                }else {
                    c1Points += 0;
                }
            }
        }
        
        if(checkIfBlank(c2Hand) == true) {
            c2Points = 0;
        }else {
            for (int i = 0; i < c2Hand.length(); i++) {
                String temp = c2Hand.substring(i, i + 1);
                if (temp.equals("A")) {
                    c2Points += ACE;
                }else if(temp.equals("2")) {
                    c2Points += TWO;
                }else if(temp.equals("3")) {
                    c2Points += THREE;    
                }else if(temp.equals("4")) {
                    c2Points += FOUR;
                }else if(temp.equals("5")) {
                    c2Points += FIVE;
                }else if(temp.equals("6")) {
                    c2Points += SIX;
                }else if(temp.equals("7")) {
                    c2Points += SEVEN;
                }else if(temp.equals("8")) {
                    c2Points += EIGHT;
                }else if(temp.equals("9")) {
                    c2Points += NINE;
                }else if(temp.equals("10")) {
                    c2Points += TEN;
                }else if(temp.equals("J")) {
                    c2Points += JACK;
                }else if(temp.equals("Q")) {
                    c2Points += QUEEN;
                }else if(temp.equals("K")) {
                    c2Points += KING;
                }else {
                    c2Points += 0;
                }
            }
        }
        return Integer.toString(playerPoints) + "-" + Integer.toString(c1Points) + "*" + Integer.toString(c2Points);
    }

    /**
     * *If computer has a card of the same suit it plays that first
     * 
     * *Else if they have a card of same rank it plays that
     * 
     * *Else if they have an eight they play that *They will choose a suit in their
     * *hand (Math.random()) 
     * *If another player has one card left, they will swap the
     * *suit if they can (probably check this first)
     */
    // *Plays for both computers
    private static String processComputer(String c1Hand, String topCard, String playerHand, String c2Hand) {
        int firstSuit = c1Hand.indexOf(topCard.substring(topCard.length() - 1));
        int firstFace = c1Hand.indexOf(topCard.substring(0, topCard.length() - 1));
        boolean hasPlayed = false;
        while (!hasPlayed) {
            if (topCard.contains("-") == true) {
                topCard = topCard.replaceAll("-", "");
            } else {
                if (checkFace(c1Hand, topCard) == false && checkSuit(c1Hand, topCard) == false
                        && c1Hand.indexOf("8") < 0) {
                    System.out.println("Computer can't play!");
                    c1Hand = computerDrawCard(c1Hand, topCard);
                    hasPlayed = true;
                    System.out.println("The top card is: " + topCard);
                    System.out.println("\n-----------------------------------------------------------\n");
                } else if ((playerHand.trim().length() < 4 || c2Hand.trim().length() < 4) && (c1Hand.indexOf("8") >= 0)
                        || checkFace(c1Hand, topCard) == true) {
                    if (checkFace(c1Hand, topCard) == true && firstFace >= 0) {
                        if (topCard.substring(0, 2).equals("10")) {
                            topCard = c1Hand.substring(firstFace, firstFace + 3);
                            c1Hand = c1Hand.replaceFirst(topCard, "");
                            hasPlayed = true;
                            System.out.println("Computer Played " + topCard);
                            System.out.println("The top card is: " + topCard);
                            System.out.println("\n-----------------------------------------------------------\n");
                        } else {
                            topCard = c1Hand.substring(firstFace, firstFace + 2);
                            c1Hand = c1Hand.replaceFirst(topCard, "");
                            hasPlayed = true;
                            System.out.println("Computer Played " + topCard);
                            System.out.println("The top card is: " + topCard);
                            System.out.println("\n-----------------------------------------------------------\n");
                        }
                    } else if (c1Hand.contains("8")) {
                        topCard = computerChangeSuit(topCard, c1Hand);
                        c1Hand = c1Hand.replaceFirst(c1Hand.substring(c1Hand.indexOf("8"), c1Hand.indexOf("8") + 2),
                                "");
                        hasPlayed = true;
                        System.out.println("Computer Played " + topCard);
                        System.out.println("The top card is: " + topCard);
                        System.out.println("\n-----------------------------------------------------------\n");
                    }
                } else if (checkSuit(c1Hand, topCard) == true && firstSuit >= 0) {
                    if (c1Hand.substring(firstSuit - 1, firstSuit).equals("0")) {
                        topCard = c1Hand.substring(firstSuit - 2, firstSuit + 1);
                        c1Hand = c1Hand.replaceFirst(topCard, "");
                        hasPlayed = true;
                        System.out.println("Computer Played " + topCard);
                        System.out.println("The top card is: " + topCard);
                        System.out.println("\n-----------------------------------------------------------\n");
                    } else {
                        topCard = c1Hand.substring(firstSuit - 1, firstSuit + 1);
                        c1Hand = c1Hand.replaceFirst(topCard, "");
                        hasPlayed = true;
                        System.out.println("Computer Played " + topCard);
                        System.out.println("The top card is: " + topCard);
                        System.out.println("\n-----------------------------------------------------------\n");
                    }

                } else if (checkFace(c1Hand, topCard) == true && firstFace >= 0) {
                    if (topCard.substring(0, 2).equals("10")) {
                        topCard = c1Hand.substring(firstFace, firstFace + 3);
                        c1Hand = c1Hand.replaceFirst(topCard, "");
                        hasPlayed = true;
                        System.out.println("Computer Played " + topCard);
                        System.out.println("The top card is: " + topCard);
                        System.out.println("\n-----------------------------------------------------------\n");
                    } else {
                        topCard = c1Hand.substring(firstFace, firstFace + 2);
                        c1Hand = c1Hand.replaceFirst(topCard, "");
                        hasPlayed = true;
                        System.out.println("Computer Played " + topCard);
                        System.out.println("The top card is: " + topCard);
                        System.out.println("\n-----------------------------------------------------------\n");
                    }
                } else if (c1Hand.indexOf("8") >= 0) {
                    topCard = computerChangeSuit(topCard, c1Hand);
                    c1Hand = c1Hand.replaceFirst(c1Hand.substring(c1Hand.indexOf("8"), c1Hand.indexOf("8") + 2), "");
                    hasPlayed = true;
                    System.out.println("Computer Played " + topCard);
                    System.out.println("The top card is: " + topCard);
                    System.out.println("\n-----------------------------------------------------------\n");
                }
            }
        }
        return c1Hand.replaceAll("\\s+", " ") + "-" + topCard;
    }

    // *Allows the player to play, change suit and draw cards when needed
    private static String processPlayer(Scanner in, String playerHand, String topCard) {
        boolean validInput = false;

        while (!validInput) {
            if (topCard.contains("-") == true) {
                topCard = topCard.replaceAll("-", "");
            } else {
                if (checkFace(playerHand, topCard) == false && checkSuit(playerHand, topCard) == false
                        && playerHand.indexOf("8") < 0) {
                    System.out.println("You can't play!");
                    playerHand = drawCard(playerHand, topCard);
                    validInput = true;
                    System.out.println("The top card is: " + topCard);
                    System.out.println("\n-----------------------------------------------------------\n");
                } else if (checkHand(playerHand, topCard) == true || playerHand.indexOf("8") >= 0) {
                    System.out.print("What card would you like to play (" + playerHand.trim() + "): ");
                    String card = in.nextLine().toUpperCase();
                    System.out.println("\n-----------------------------------------------------------\n");
                    if (validateCard(card) == false || playerHand.indexOf(card) < 0 || card.length() < 2) {
                        System.out.println("Invalid Input!");
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
                            } else if (newSuit.equals("SPADES")) {
                                topCard = "8S";
                                playerHand = playerHand.replaceFirst(card, "");
                                validInput = true;
                                System.out.println("The new suit is: " + newSuit);
                                System.out.println("\n-----------------------------------------------------------\n");
                            }
                        } else {
                            System.out.println("Invalid Input!");
                            System.out.println("Enter new suit (Hearts, Diamonds, Spades, Clubs): ");
                            System.out.println("\n-----------------------------------------------------------\n");
                        }
                    } else if (checkSuit(card, topCard) == false && checkFace(card, topCard) == false) {
                        System.out.println("Invalid Input!");
                        System.out.println("The top card is: " + topCard);
                        System.out.println("\n-----------------------------------------------------------\n");
                    } else if (playerHand.indexOf(card) >= 0
                            && (checkFace(card, topCard) == true || checkSuit(card, topCard) == true)) {
                        topCard = card;
                        playerHand = playerHand.replaceFirst(card, "");
                        validInput = true;
                        System.out.println("The top card is: " + topCard);
                        System.out.println("\n-----------------------------------------------------------\n");
                    }
                }
            }
        }
        return playerHand.replaceAll("\\s+", " ") + "-" + topCard;
    }

    // *Iterates through the player's hand to see if they have a matching suit
    // and/or rank
    private static boolean checkHand(String playerHand, String topCard) {
        boolean validInput = false;

        while (!validInput) {
            for (int i = 0; i < playerHand.length(); i++) {
                String temp = playerHand.substring(i, i + 1);
                if (topCard.indexOf(temp) >= 0) {
                    validInput = true;
                    return true;
                }
            }
        }
        return false;
    }

    // *Makes the player draw up to 5 cards
    private static String drawCard(String playerHand, String topCard) {
        for (int i = 0; i < 5; i++) {
            String newCard = getCard();
            if (checkFace(playerHand, topCard) == true || checkSuit(playerHand, topCard) == true
                    || newCard.indexOf("8") >= 0) {
                break;
            } else {
                playerHand += newCard + " ";
                System.out.println("You drew a " + newCard);
            }
        }
        System.out.println("\n-----------------------------------------------------------\n");
        return " " + playerHand;
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
        String validCards = "AS2S3S4S5S6S7S8S9S10SJSQSKSAC2C3C4C5C6C7C8C9C10CJCQCKCAD2D3D4D5D6D7D8D9D10DJDQDKDAH2H3H4H5H6H7H8H9H10HJHQHKH";
        if (validCards.indexOf(card) >= 0) {
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
            return ACE_FACE;
        else if (suit == 11)
            return JACK_FACE;
        else if (suit == 12)
            return QUEEN_FACE;
        else
            return KING_FACE;
    }

    private static String computerChangeSuit(String topCard, String c1Hand) {
        int newSuit = (int) Math.random() * 3;

        if (topCard.substring(topCard.length() - 1).equals("H")) {
            if (newSuit == 0) {
                topCard = "8C";
            } else if (newSuit == 1) {
                topCard = "8D";
            } else {
                topCard = "8S";
            }
        } else if (topCard.substring(topCard.length() - 1).equals("S")) {
            if (newSuit == 0) {
                topCard = "8C";
            } else if (newSuit == 1) {
                topCard = "8D";
            } else {
                topCard = "8H";
            }
        } else if (topCard.substring(topCard.length() - 1).equals("C")) {
            if (newSuit == 0) {
                topCard = "8S";
            } else if (newSuit == 1) {
                topCard = "8D";
            } else {
                topCard = "8H";
            }
        } else {
            if (newSuit == 0) {
                topCard = "8C";
            } else if (newSuit == 1) {
                topCard = "8S";
            } else {
                topCard = "8H";
            }
        }
        return topCard;
    }

    private static String computerDrawCard(String c1Hand, String topCard) {
        for (int i = 0; i < 5; i++) {
            String newCard = getCard();
            if (checkFace(c1Hand, topCard) == true || checkSuit(c1Hand, topCard) == true || newCard.indexOf("8") >= 0) {
                break;
            } else {
                c1Hand += newCard + " ";
                System.out.println("Computer drew a " + newCard);
            }
        }
        System.out.println("\n-----------------------------------------------------------\n");
        return " " + c1Hand;
    }
}