package week2;

public class HW10 {
    public static void main(String[] args) {
        double a = 3;
        double b = 21;
        double c = 8;
        double x = Math.sqrt(((b * b) - 4 * a * c));
        double equationPlus = (-b + x) / (2 * a);
        double equationMinus = (-b - x) / (2 * a);
        System.out.println("The roots are: " + equationPlus + " and " + equationMinus);
    }
}
