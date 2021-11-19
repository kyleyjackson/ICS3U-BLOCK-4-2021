package week11;

public class Sound {
    private int samples[];

    public int limitAmplitude(int limit) {
        int numChanged = 0;

        for (int i = 0; i < samples.length; i++) {
            if(samples[i] > limit) {
                samples[i] = limit;
                numChanged++;
            }else if(samples[i] < -limit) {
                samples[i] = -limit;
                numChanged++;
            }
        }
        return numChanged;
    }

    public void trimSilenceFromBeginning() {
        int numZero = 0;

        while(samples[numZero] == 0) {
            numZero++;
        }

        int[] temp = new int[samples.length - numZero];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = samples[i + numZero];
        }

        samples = temp;
    }
}
