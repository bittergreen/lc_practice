package backtracking;

import java.util.ArrayList;
import java.util.List;

// 78. Subsets
public class Solution46 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0);
        return res;
    }

    void dfs(int depth) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        dfs(depth+1);
        path.add(nums[depth]);
        dfs(depth+1);
        path.removeLast();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        Solution46 solution = new Solution46();
        List<List<Integer>> lists = solution.subsets(nums);
        System.out.println(lists);
    }
}
