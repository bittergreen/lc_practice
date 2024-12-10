package backtracking;

import java.util.ArrayList;
import java.util.List;

// 39. Combination Sum
public class Solution48 {

    int target;
    int[] candidates;
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int curSum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates.length == 0) return res;
        this.target = target;
        this.candidates = candidates;

        dfs(0);
        return res;
    }

    void dfs(int depth) {
        if (curSum >= target) {
            if (!path.isEmpty() && curSum == target) res.add(new ArrayList<>(path));
            return;
        }

        for (int i=depth; i<candidates.length; i++) {
            int now = candidates[i];
            curSum += now;
            path.add(now);
            dfs(i);
            path.removeLast();
            curSum -= now;
        }
    }

    public static void main(String[] args) {
        Solution48 sol = new Solution48();
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(sol.combinationSum(candidates, target));
    }
}
