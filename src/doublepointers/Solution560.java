package doublepointers;

// 560. Subarray Sum Equals K
public class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        // double pointers
        for (int l=0; l<nums.length; l++) {
            int tmpSum = 0;
            int r = l;
            while (r < nums.length) {
                tmpSum += nums[r];
                if (tmpSum == k) res++;
                r++;
            }
        }
        return res;
    }
}
