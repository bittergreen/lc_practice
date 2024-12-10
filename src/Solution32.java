import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


// 42. Trapping Rain Water
public class Solution32 {

    public int trap(int[] height) {
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        int leftP = 1;
        int rightP = height.length-2;
        while (leftP <= rightP) {
            leftMax = Math.max(leftMax, height[leftP-1]);
            rightMax = Math.max(rightMax, height[rightP+1]);
            if (leftMax >= rightMax) {
                res += Math.max(rightMax - height[rightP], 0);
                rightP--;
            } else {
                res += Math.max(leftMax - height[leftP], 0);
                leftP++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {7,9,8,5,0,0,4,2,7,6,0,8,1,2,3};
        Solution32 sol = new Solution32();
        System.out.println(sol.trap(height));
    }
}
