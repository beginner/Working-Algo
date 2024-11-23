package string;

/**
 * https://www.youtube.com/watch?v=jvRiCOEflXA
 * https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful
 */
public class LC2914_BeautifulString {

    public int minChanges(String s) {
        int change = 0;

        int count = 0;
        char prev = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == prev) {
                count++;
                continue;
            }

            if (count % 2 == 0) {
                prev = s.charAt(i);
                count = 1;
            } else {
                change += 1;
                count = 0;
            }
        }

        return change;
    }

}
