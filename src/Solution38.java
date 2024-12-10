// 238. Product of Array Except Self
public class Solution38 {

    public int[] productExceptSelf(int[] nums) {
        int[] prev = new int[nums.length];
        int[] post = new int[nums.length];
        int[] res = new int[nums.length];

        prev[0] = 1;
        post[nums.length-1] = 1;
        for (int i=1; i<nums.length; i++) {
            prev[i] = prev[i-1] * nums[i-1];
        }
        for (int i=nums.length-2; i>=0; i--) {
            post[i] = post[i+1] * nums[i+1];
        }
        for (int i=0; i<nums.length; i++) {
            res[i] = prev[i] * post[i];
        }
        return res;
    }

    public int[] productExceptSelf2(int[] nums) {
        int[] suff = new int[nums.length];

        suff[nums.length-1] = 1;
        for (int i=nums.length-2; i>=0; i--) {
            suff[i] = suff[i+1] * nums[i+1];
        }

        int prev = 1;
        for (int i=0; i<nums.length; i++) {
            suff[i] = prev * suff[i];
            prev *= nums[i];
        }

        return suff;
    }

}
