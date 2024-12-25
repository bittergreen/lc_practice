package doublepointers;

// 11. 盛最多水的容器
public class Solution11 {

    public int maxArea(int[] height) {

        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = (right - left) * Math.min(height[right], height[left]);
            max = Math.max(area, max);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;

    }
}
