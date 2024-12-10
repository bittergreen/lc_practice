// 88. 合并两个有序数组

public class Solution1 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = nums1.length - 1;
        while (j >= 0) {
            nums1[k--] = i>=0 && nums1[i]>nums2[j] ? nums1[i--] : nums2[j--];
        }

        for (int a: nums1) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};
        int m = 0;
        int n = 1;
        Solution1 sol = new Solution1();
        sol.merge(nums1, m, nums2, n);
    }
}
