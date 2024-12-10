import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 15. 3Sum
public class Solution31 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int lastK = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();
        for (int k=0; k<nums.length; k++) {
            if (nums[k] > 0 || k>nums.length-3) break;
            while (nums[k] == lastK && k<=nums.length - 3) {
                lastK = nums[k];
                k++;
            }
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                // traverse for each k
                int tmp = nums[i] + nums[j] + nums[k];
                while (tmp < 0 && i < j) {
                    i++;
                    tmp = nums[i] + nums[j] + nums[k];
                }
                while (tmp > 0 && i < j) {
                    j--;
                    tmp = nums[i] + nums[j] + nums[k];
                }
                if (i == j) break;
                // find 1
                if (tmp == 0) {
                    List<Integer> oneRes = new ArrayList<>();
                    oneRes.add(nums[k]);
                    oneRes.add(nums[i]);
                    oneRes.add(nums[j]);
                    res.add(oneRes);
                }
                // skip same elements
                while (i < j && nums[i] == nums[i+1]) i++;
                i++;
            }
            lastK = nums[k];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution31 sol = new Solution31();
        int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        System.out.println(sol.threeSum(nums));
    }
}
