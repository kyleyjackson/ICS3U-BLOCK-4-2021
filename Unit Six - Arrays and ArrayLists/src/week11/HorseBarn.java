package week11;

public class HorseBarn {
    private Horse[] spaces;

    public int findHorseSpace(String name) {
        for (int i = 0; i < spaces.length; i++) {
            Horse temp = spaces[i];

            if(temp != null && temp.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void consolidate() {
        Horse[] temp = new Horse[spaces.length];
        int i = 0;
        
        for (Horse horse : temp) {
            if (horse != null) {
                temp[i] = horse;
                i++;
            }
        }
        spaces = temp;
    }
}
