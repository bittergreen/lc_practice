package array_string;

// 189. Rotate Array
public class Solution189 {
    public void rotate(int[] nums, int k) {
        if (k > nums.length) {
            k = k % nums.length;
        }
        if (k == 0) return;

        int[] store = new int[k];
        // store the last k elems of nums
        for (int i=0; i<k; i++) {
            store[i] = nums[nums.length - k + i];
        }
        // update
        for (int i=nums.length-1; i>=k; i--) {
            nums[i] = nums[i-k];
        }
        for (int i=0; i<k; i++) {
            nums[i] = store[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        Solution189 sol = new Solution189();
        sol.rotate(nums, 3);
    }
}
