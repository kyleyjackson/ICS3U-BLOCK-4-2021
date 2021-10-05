package week4;

public class BayviewGlenPools {
    public static void main(String[] args) {
        final int length = 20;
        final int width = 8;
        final int shallowLength = 5;
        final int transition = 7;
        final int shallowHeight = 3;
        final int deepHeight = 8;
        final int linerCost = 2;

        double volume = getVolume(length, width, shallowHeight, shallowLength, deepHeight, transition);
        double surfaceArea = getSurfaceArea(length, width, shallowHeight, shallowLength, deepHeight, transition);
        double linerCostFinal = linerCost * surfaceArea;
        double ninetyPercentFull = volume * 0.9;

        System.out.println("The volume is: " + volume);
        System.out.println("The surface area is: " + surfaceArea);
        System.out.println("The cost of liner is: " + linerCostFinal);
        System.out.println("90% of the pool's volume is: " + ninetyPercentFull);
        System.out.println("The amount of liner needed to line the pool is: " + surfaceArea + "m^2");

    }

    private static double getSurfaceArea(int length, int width, int shallowHeight, int shallowLength, int deepHeight,
            int transition) {
        int tHeight = deepHeight - shallowHeight;
        double tLength = Math.sqrt(Math.pow(transition, 2) - Math.pow(tHeight, 2));
        double deepLength = length - tLength - shallowLength;
        double tWalls = (((tLength * tHeight) / 2) + (tLength * shallowHeight)) * 2;
        double tArea = transition * width + tWalls;
        double deepWalls = (deepHeight * width) + ((deepHeight * deepLength) * 2);
        double deepArea = deepLength * width + deepWalls;
        double shallowWalls = (shallowHeight * width) + ((shallowHeight * shallowLength) * 2);
        double shallowArea = shallowLength * width + shallowWalls;
        return tArea + deepArea + shallowArea;
    }

    private static double getVolume(int length, int width, int shallowHeight, int shallowLength, int deepHeight,
            int transition) {
        int tHeight = deepHeight - shallowHeight;
        double tLength = Math.sqrt(Math.pow(transition, 2) - Math.pow(tHeight, 2));
        double shallowVolume = shallowHeight * shallowLength * width;
        double deepLength = length - tLength - shallowLength;
        double deepVolume = deepLength * deepHeight * width;
        double tVolume1 = ((tLength * tHeight) / 2) * width;
        double tVolume2 = tLength * shallowHeight * width;
        return deepVolume + shallowVolume + tVolume1 + tVolume2;
    }

}
