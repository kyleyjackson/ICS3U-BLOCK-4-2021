package week3;

public class RandomNumberExample {
    public static void main(String[] args) {
        /*
         * for (int i = 0; i < 100; i++) { for loop, to repeat the command 100 times
         * System.out.println(Math.random()); }
         */
        double r = Math.random();
        System.out.println(r);

        int lower = -5;
        int upper = 5;

        int random = (int) (r * (upper - lower + 1)) + lower;

        String str = "Random Numbers"; // *Change a random letter in str to "x"

        int randomIndex = (int) Math.random() * str.length();

        str = str.substring(0, randomIndex) + "x" + str.substring(randomIndex + 1);

        System.out.println(str);
    }
}