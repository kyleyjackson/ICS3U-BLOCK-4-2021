package week11;

public class NumberCube {

    public int toss() {
        return (int) (Math.random() * 6) + 1;
    }

    public static int[] getCubeTosses(NumberCube cube, int numTosses) {
        int[] arr = new int[numTosses];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = cube.toss();
        }

        return arr;
    }

    public static int getLongestRun(int[] values) {
        int consecutive = 0;

        LOOP: for (int i = 0; i < values.length - 1; i++) {
            int temp = values[i];

            if (temp == values[i] + 1) {
                consecutive++;
            } else {
                break LOOP;
            }
        }

        if (consecutive > 0) {
            return consecutive;
        } else {
            return -1;
        }
    }
}
