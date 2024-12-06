package string;

public class LC1455_StringPrefix {

    public static void main(String[] args) {
        String sentence = "hellohello hellohellohello";
        String searchWord = "ell";
        LC1455_StringPrefix problem = new LC1455_StringPrefix();
        System.out.println(problem.isPrefixOfWord(sentence, searchWord));
    }

    public int isPrefixOfWord(String sentence, String searchWord) {

        int i = 0;
        int j = 0;
        int index = 1;
        int matched = 0;


        while (i < sentence.length()) {
            char c = sentence.charAt(i);
            if (c == ' ') {
                matched = 0;
                index++;
            } else {
                if (matched !=-1 && (searchWord.charAt(matched) == sentence.charAt(i))) {
                    matched++;
                    if (matched == searchWord.length()) return index;
                } else {
                    matched = -1;
                }
            }
            i++;
        }

        return -1;
    }
}
