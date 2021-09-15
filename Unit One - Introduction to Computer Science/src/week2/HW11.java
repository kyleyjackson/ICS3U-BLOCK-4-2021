package week2;

public class HW11 {
        public static void main(String[] args) {
                int i = 5, j = 4, k = 3;
                double x = 5.5, y = 3.0, z = -2.0;
                // First statement
                int statement1Original = (i - (i - (i - (i - j))));
                int a = i - j;
                int b = i - a;

                System.out.println("The first original statment is: " + statement1Original
                                + " And the simplified statement is: " + b);

                // Second statement
                double statement2Original = ((x - y) - (y - x) - (x - y) - (y - x));
                double c = x - y;
                double d = c - (y - x);

                System.out.println("The second original statment is: " + statement2Original
                                + " And the simplified statement is: " + d);

                // Third statement
                int statement3Original = (i + j / k + i - j);
                int e = i * 2;
                int f = j / k;
                int g = e + f;
                int h = g - j;

                System.out.println("The third original statment is: " + statement3Original
                                + " And the simplified statement is: " + h);

                // Fourth statement
                double statement4Original = (double) (i + j / k);
                double l = (double) i + j;
                double m = l / k;
                m *= 2;

                System.out.println("The fourth original statment is: " + statement4Original
                                + " And the simplified statement is: " + m);

                // Fifth statement
                double statement5Original = (int) (x / k - x / k);
                double n = x / k;
                double o = n - n;

                System.out.println("The fifth original statment is: " + statement5Original
                                + " And the simplified statement is: " + o);

                // Sixth statement
                double statement6Original = ((double) i / j - (double) i / j);
                double p = (double) i / j;
                double q = p - p;

                System.out.println("The sixth original statment is: " + statement6Original
                                + " And the simplified statement is: " + q);
        }
}
