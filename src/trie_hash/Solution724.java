// 724. 寻找数组的中心下标
package trie_hash;


public class Solution724 {

    public int pivotIndex(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }
        int arraySum = preSum[preSum.length - 1];
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (preSum[i] == arraySum - nums[i] - preSum[i]) {
                ans = i;
                return ans;
            }
        }
        return ans;
    }

}
