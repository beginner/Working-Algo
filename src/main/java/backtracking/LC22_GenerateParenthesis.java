package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC22_GenerateParenthesis {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0, new StringBuilder());
        return result;
    }

    private void backtrack(int n, int open, int closed, StringBuilder sb) {
        if (open == n && closed == n) {
            result.add(sb.toString());
            return;
        }

        if (open < n) {
            int len = sb.length();
            backtrack(n, open + 1, closed, sb.append('('));
            sb.setLength(len);
        }
        if (closed < open) {
            int len = sb.length();
            backtrack(n, open, closed + 1, sb.append(')'));
            sb.setLength(len);
        }
    }
}
