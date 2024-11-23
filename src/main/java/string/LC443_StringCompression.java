package string;

public class LC443_StringCompression {

    // TC -> O(n)
    // SC -> O(1)
    public int compress(char[] chars) {
        int i = 0;
        int len = chars.length;
        int res = 0;
        while (i < len) {
            int groupLength = 1;
            while (i + groupLength < len && chars[i] == chars[i+groupLength]) {
                groupLength++;
            }
            chars[res++] = chars[i];
            if (groupLength > 1) {
                for (char c : Integer.toString(groupLength).toCharArray()) {
                    chars[res++] = c;
                }
            }
            i += groupLength;
        }
        return res;
    }

}
