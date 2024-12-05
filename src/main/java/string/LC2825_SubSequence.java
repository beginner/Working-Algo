package string;

public class LC2825_SubSequence {

    public boolean canMakeSubsequence(String str1, String str2) {

        int i = 0;
        int j = 0;

        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else {
                int nextIndex = ((str1.charAt(i) - 'a') + 1) % 26;
                if ((char)(nextIndex + 'a') == str2.charAt(j)) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
        }
        return j == str2.length();
    }

}
