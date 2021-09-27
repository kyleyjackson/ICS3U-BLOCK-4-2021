package week3;

public class UnitTest {
    public static void main(String[] args) {
        System.out.println(threeCopies("Apple", 3));
        System.out.println(threeCopies("Computer", 2));
        System.out.println(removeChars("Computer Science", 3, 4));
        System.out.println(removeChars("Tired", 2, 3));
        System.out.println(sqrtSum(7765));
    }

    /**
     * *Write a function which accepts a string and an integer. *Return three copies
     * *of a substring of length 2 at the specified index
     */
    // * threeCopies("happy", 2) => "pppppp"
    // * threeCopies("apple", 3) => "lelele"
    public static String threeCopies(String str, int index) {
        String s = str.substring(index, index + 2);
        return s + s + s;
    }

    /**
     * 
     * *removeChars("Happy", 1, 2) => "Hpy" *removeChars("Computer Science", 0, 3)
     * *=> "puter Science" *removeChars("Tired", 2, 3) => "Ti"
     */

    public static String removeChars(String str, int index, int n) {
        String s = str.substring(0, index);
        String s1 = str.substring(index + n);
        return s + s1;
    }

    // *7765
    public static double sqrtSum(int number) {
        int a = number / 1000; // * = 7
        int b = number / 100 % 10; // * = 7
        int c = number / 10 % 10; // * = 6
        int d = number % 10; // * = 5
        return Math.sqrt(a + b + c + d); // * = 25
    }
}
