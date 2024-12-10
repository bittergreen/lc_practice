// 45. 跳跃游戏 II
public class Solution9 {

    public int jump(int[] nums) {
        int step = 0;
        int now = 0;
        int bound = now + nums[now];
        int end = now + nums[now];
        while (now < nums.length-1) {
            if (end >= nums.length-1) {
                step += 1;
                break;
            }
            for (int i=now+1; i<=end; i++) {
                // greedy
                if (i+nums[i] > bound) {
                    now = i;
                    bound = now + nums[i];
                }
            }
            end = bound;
            step += 1;
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = {2,1};
        Solution9 sol = new Solution9();
        int res = sol.jump(nums);
        System.out.println(res);
    }
}
