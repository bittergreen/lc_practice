package backtracking;// 46. Permutations
import java.util.ArrayList;
import java.util.List;


public class Solution45 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;

        int depth = 0;
        boolean[] visited = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();

        dfs(nums, res, depth, visited, path);
        return res;
    }

    void dfs(int[] nums, List<List<Integer>> res, int depth,
             boolean[] visited, List<Integer> path) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (!visited[i]) {
                path.add(nums[i]);
                visited[i] = true;
                depth++;
                dfs(nums, res, depth, visited, path);
                visited[i] = false;
                depth--;
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        Solution45 solution = new Solution45();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }
}
