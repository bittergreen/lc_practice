// 26. 删除有序数组中的重复项
public class Solution3 {

    public int removeDuplicates(int[] nums) {
        int j = 0;
        int tmp = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != tmp) {
                nums[j++] = nums[i];
            }
            tmp = nums[i];
        }
        for (int a : nums) {
            System.out.println(a);
        }
        return j;

    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        Solution3 sol = new Solution3();
        int k = sol.removeDuplicates(nums);
        System.out.println(k);
    }
}
