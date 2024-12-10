// 27. 移除元素
public class Solution2 {

    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int val = 1;
        Solution2 sol = new Solution2();
        int k = sol.removeElement(nums, val);
        System.out.println(k);
    }


}
