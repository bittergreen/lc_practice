package greedy;

// 55. 跳跃游戏
public class Solution8 {

    public boolean canJump(int[] nums) {

        int reach = 0;

        for (int i=0; i<nums.length; i++) {
            if (reach >= i && i + nums[i] > reach) reach = i + nums[i];
        }
        return reach >= nums.length - 1;

    }
}
