package week1;

public class Money {
    public static void main(String[] args) {
        double pennies = 15;
        double nickels = 25;
        double dimes = 40;
        double quarters = 37;
        double loonies = 10;
        double toonies = 2;
        double totalMoney = (pennies * 0.01) + (nickels * 0.05) + (dimes * 0.1) + (quarters * 0.25) + loonies
                + (toonies * 2);
        System.out.print("$" + totalMoney);
    }
}
