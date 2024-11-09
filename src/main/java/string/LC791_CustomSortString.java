package string;

import java.util.HashMap;
import java.util.Map;

public class LC791_CustomSortString {

    // TC -> O(n)
    // SC -> O(n)
    public String customSortString(String order, String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int existing = freq.getOrDefault(c, 0);
            freq.put(c, existing + 1);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            int f = freq.getOrDefault(c, 0);
            while (f-- > 0) {
                sb.append(c);
            }
            freq.remove(c);
        }

        for (var entry : freq.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++)
                sb.append(entry.getKey());
        }

        return sb.toString();
    }

}
