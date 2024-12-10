package search;

// 35. Search Insert Position
public class Solution35 {
    public int searchInsert(int[] nums, int target) {

        if (nums.length == 0 || target < nums[0]) return 0;
        if (target > nums[nums.length-1]) return nums.length;
        int start = 0;
        int end = nums.length - 1;
        while (end >= start) {
            int mid = (end + start) / 2;
            if (target > nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {1,3};
        Solution35 sol = new Solution35();
        System.out.println(sol.searchInsert(nums, 2));
    }
}
