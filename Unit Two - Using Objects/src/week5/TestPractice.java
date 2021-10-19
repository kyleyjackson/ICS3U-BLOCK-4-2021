package week5;

public class TestPractice {
    public static void main(String[] args) {
        backwardsWord("This is a test");
        System.out.println("-------------------------------------------");
        asterisks(3, 4);
        System.out.println("-------------------------------------------");
        
    }

    private static void asterisks(int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }

    private static void backwardsWord(String str) {
        String temp = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            temp = temp + str.charAt(i);
        }
        System.out.println(temp);
    }
}