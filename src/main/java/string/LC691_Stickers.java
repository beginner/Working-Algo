package string;

import java.util.HashMap;

// Not optimized
// Time -> Take a character from sticker or not take -
// N = length of original target
// M = number of stickers
// Time = (2 ^ N * M)
// Space = (2 ^ N) -> all the subsequences of the target string

public class LC691_Stickers {

    public static void main(String[] args) {
        String[] stickers = {"these","guess","about","garden","him"};
        String target = "atomher";
        LC691_Stickers problem = new LC691_Stickers();
        System.out.println(problem.minStickers(stickers, target));
    }

    // Key - target subsequence
    // Value - minimum number of stickers required
    HashMap<StringBuilder, Integer> cache = new HashMap<>();
    HashMap<String, HashMap<Character, Integer>> stickerToFreqMap = new HashMap<>();

    public int minStickers(String[] stickers, String target) {

        for (String sticker : stickers) {
            stickerToFreqMap.put(sticker, createFreqMap(new StringBuilder(sticker)));
        }

        int retVal = dfs(new StringBuilder(target));
        return retVal == Integer.MAX_VALUE ? -1 : retVal;
    }

    private int dfs(StringBuilder t) {
        if (t.isEmpty()) return 0;
        if (cache.containsKey(t)) {
            return cache.get(t);
        }

        final var freqMap = createFreqMap(t);
        int ans = Integer.MAX_VALUE;
        HashMap<Character, Integer> copy = new HashMap<>();
        for (var entry : stickerToFreqMap.entrySet()) {
            if (!entry.getValue().containsKey(t.charAt(0))) {
                continue;
            }
            copy = new HashMap<>(entry.getValue());
            final var freMapCopy = new HashMap<>(freqMap);
            for (var target : freqMap.entrySet()) {
                if (copy.containsKey(target.getKey())) {
                    int min = Math.min(copy.get(target.getKey()), freMapCopy.get(target.getKey()));
                    copy.put(target.getKey(), copy.get(target.getKey()) - min);
                    freMapCopy.put(target.getKey(), freMapCopy.get(target.getKey()) - min);
                    if (copy.get(target.getKey()) == 0) copy.remove(target.getKey());
                    if (freMapCopy.get(target.getKey()) == 0) freMapCopy.remove(target.getKey());
                }
            }
            StringBuilder newTarget = new StringBuilder();
            for (var e : freMapCopy.entrySet()) {
                for (int i = 0; i < e.getValue(); i++) {
                    newTarget.append(e.getKey());
                }
            }
            int result = dfs(newTarget);
            int temp = result == Integer.MAX_VALUE ? Integer.MAX_VALUE : 1 + result;
            ans = Math.min(ans, temp);
        }


        cache.put(t, ans);
        return ans;
    }


    private HashMap<Character, Integer> createFreqMap(StringBuilder sticker) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < sticker.length(); i++) {
            char c = sticker.charAt(i);
            int existing = map.getOrDefault(c, 0);
            map.put(c, existing + 1);
        }
        return map;
    }
}
