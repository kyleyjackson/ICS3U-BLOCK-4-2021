package week3;

public class ExtraPractice {
    public static void main(String[] args) {
        System.out.println(randomInt());
        System.out.println(randomIntTwo());
        System.out.println(diceRoll());
        System.out.println(randomIntThree(20, 10));
        System.out.println(removeLetterE("Eat apples"));
        System.out.println(removeSubString("I like to eat apples", 2, 10));
        System.out.println(sumOfStringLengths("I enjoy pie", "That was a lie"));
        System.out.println(slopeOfLine(10, 50, 15, 27));
        System.out.println(volumeOfCylinder(40, 20));
        System.out.println(removeRandomChars("I like to eat apples"));

    }

    public static int randomInt() {
        int n = (int) (Math.random() * 100) + 1;
        return n;
    }

    public static int randomIntTwo() {
        int n = (int) (Math.random() * 100) - 49;
        return n;
    }

    public static int diceRoll() {
        int n = (int) (Math.random() * 6) + 1;
        return n;
    }

    public static int randomIntThree(int bigNum, int smallNum) {
        int n = (int) (Math.random() * bigNum) - smallNum;
        return n;
    }

    public static String removeLetterE(String str) {
        if (str.contains("E")) {
            str = str.replaceFirst("E", "");
        } else if (str.contains("e")) {
            str = str.replaceFirst("e", "");
        }
        return str;
    }

    public static String removeSubString(String str, int index1, int index2) {
        String subStr = str.substring(index1, index2);
        return str.replaceFirst(subStr, "");
    }

    public static int sumOfStringLengths(String str, String str1) {
        return str.length() + str1.length();
    }

    public static String slopeOfLine(int x1, int x2, int y1, int y2) {
        int xChange = x2 - x1;
        int yChange = y2 - y1;
        return "The slope is: " + yChange + "/" + xChange;
    }

    public static double volumeOfCylinder(int h, int r) {
        final double pi = 3.14158265368979;
        return pi * r * r * h;
    }

    public static String removeRandomChars(String str) {
        int randomIndex = (int) (Math.random() * str.length());
        return str.substring(0, randomIndex) + "" + str.substring(randomIndex + 1);
    }
}
