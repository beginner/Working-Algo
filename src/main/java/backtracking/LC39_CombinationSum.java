package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC39_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>  result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 0, target, 0, candidates);
        return result;
    }

    private void backtrack(List<List<Integer>>  result, List<Integer> curr, int i, int target, int currSum, int[] candidates) {
        if (currSum > target || i >= candidates.length) {
            return;
        }
        if (currSum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }

        curr.add(candidates[i]);
        backtrack(result, curr, i, target, currSum + candidates[i], candidates);
        curr.remove(curr.size() - 1);
        backtrack(result, curr, i + 1, target, currSum, candidates);
    }

}
