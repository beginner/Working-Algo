package string;

import java.util.HashMap;
import java.util.PriorityQueue;

public class LC2182_RepeatString {

    public String repeatLimitedString(String s, int repeatLimit) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            int existing = freq.getOrDefault(c, 0);
            freq.put(c, existing + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<Character>((a, b) -> Character.compare(b, a));

        for (char c : freq.keySet()) {
            pq.offer(c);
        }

        StringBuilder sb = new StringBuilder();


        while (pq.size() > 0) {
            char poll = pq.poll();

            int use = Math.min(freq.get(poll), repeatLimit);
            freq.put(poll, freq.get(poll) - use);
            while (use-- > 0) {
                sb.append(poll);
            }
            if (freq.get(poll) > 0 && pq.size() > 0) {
                char second = pq.poll();
                sb.append(second);
                freq.put(second, freq.get(second) - 1);
                if (freq.get(second) > 0) {
                    pq.offer(second);
                }
                pq.offer(poll);
            }
        }

        return sb.toString();

    }

    public String repeatLimitedString_AnotherApproach(String s, int repeatLimit) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c-'a']++;
        }

        StringBuilder sb = new StringBuilder();

        int currentIndex = 25;
        while (currentIndex >= 0) {
            int toUse = Math.min(freq[currentIndex], repeatLimit);
            freq[currentIndex] -= toUse;
            while (toUse-- > 0) {
                sb.append((char)('a' + currentIndex));
            }
            if (freq[currentIndex] > 0) {
                int index = currentIndex - 1;
                while (index >= 0 && freq[index] == 0) index--;

                if (index < 0) break;

                sb.append((char)('a' + index));
                freq[index]--;
            } else {
                currentIndex--;
            }
        }
        return sb.toString();
    }

}
