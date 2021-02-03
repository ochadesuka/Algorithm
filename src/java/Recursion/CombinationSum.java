package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        dfs(candidates, res, c, 0, target);
        return res;
    }

    public void dfs(int[] candidates, List<List<Integer>> res, List<Integer> c, int idx, int target) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(c));
            return;
        }
        dfs(candidates, res, c, idx+1, target);
        if (target - candidates[idx] >= 0) {
            c.add(candidates[idx]);
            dfs(candidates, res, c, idx, target - candidates[idx]);
            c.remove(c.size() - 1);
        }
    }
}
