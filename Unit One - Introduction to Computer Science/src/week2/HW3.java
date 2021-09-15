package week2;

public class HW3 {
    public static void main(String[] args) {
        int num = 76859;
        int fourthDigit = num / 1000 % 10;
        int secondDigit = num / 10 % 10;
        int productNum = secondDigit * fourthDigit;
        System.out.println(secondDigit + " * " + fourthDigit + " is equal to: " + productNum);
    }
}
