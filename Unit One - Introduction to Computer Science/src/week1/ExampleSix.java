package week1;

/**
 * 
 */
public class ExampleSix {
    public static void main(String[] args) {
        int x = 1, y = 3;
        double z = 1;

        x = x + 1;
        y = y - 1;
        x = x + 3;

        // Shortcuts
        x += 1;
        y -= 1;
        x += 3;

        y = y / 2;
        z = z * 2;

        // Shortcuts
        y /= 2;
        z *= 2;

        x++; // x += 1 and x = x + 1
        y--; // y -= 1 and y = y - 1

        int s = 5;
        s++;
        ++s;
        s--;
        --s;

        int g = 3;
        int f = 3;

        int test1 = 2 * g++;
        int test2 = 2 * ++f;

    }
}
