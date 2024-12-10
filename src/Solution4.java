// 80. 删除有序数组中的重复项 II
public class Solution4 {

    public int removeDuplicates(int[] nums) {

        int k = 0;
        int last = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != last) {
                nums[k++] = nums[i];
                cnt = 0;
            } else if (cnt < 1) {
                nums[k++] = nums[i];
                cnt += 1;
            }
            last = nums[i];
        }

        return k;

    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        Solution4 sol = new Solution4();
        int k = sol.removeDuplicates(nums);
        System.out.println(k);
    }

}
