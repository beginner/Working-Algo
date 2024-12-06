package string;

public class LC2337_ObtainString {

    public boolean canChange(String start, String target) {

        int a = start.length();
        int b = target.length();

        if (a != b) return false;

        int i = 0;
        int j = 0;

        while (i < a || j < b) {
            while (i < a && start.charAt(i) == '_') i++;
            while (j < b && target.charAt(j) == '_') j++;

            // if one of the string is exhausted, ensure both are exhausted
            if (i == a || j == b) {
                return i == a && j == b;
            }
            if (start.charAt(i) != target.charAt(j)) return false;
            if (target.charAt(j) == 'L' && j > i) return false;
            if (target.charAt(j) == 'R' && i > j) return false;
            i++;
            j++;

        }
        return true;

    }

}
