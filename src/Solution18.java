// 209. 长度最小的子数组
public class Solution18 {
    public int minSubArrayLen(int target, int[] nums) {

        int left = -1;
        int minLength = nums.length + 1;
        int sum = 0;

        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                minLength = Math.min(minLength, i - left);
                // spit left elem
                left += 1;
                sum -= nums[left];
            }
        }

        minLength = minLength > nums.length ? 0 : minLength;
        return minLength;
    }

}
