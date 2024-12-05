package misc;

public class LC277_Celebrity {

    boolean knows(int i, int j) {
        return true;
    }

    public int findCelebrity(int n) {
        int celebrity = 0;
        for (int i = 0; i < n; i++) {
            if (knows(celebrity, i)) {
                celebrity = i;
            }
        }
        if (isCelebrity(celebrity, n)) return celebrity;
        return -1;
    }

    private boolean isCelebrity(int index, int num) {
        for (int i = 0; i < num; i++) {
            if (i != index && (knows(index, i) || !knows(i, index))) {
                return false;
            }
        }
        return true;
    }

}
