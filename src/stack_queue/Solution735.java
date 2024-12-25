// 735. 小行星碰撞
package stack_queue;

import java.util.Deque;
import java.util.LinkedList;

public class Solution735 {

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for (int a: asteroids) {
            boolean crashed = false;
            while (!stack.isEmpty() && a < 0 && 0 < stack.peek()) {
                int crasher = stack.peek();
                if (crasher + a > 0) {
                    crashed = true;
                    break;
                } else if (crasher + a == 0) {
                    stack.pop();
                    crashed = true;
                    break;
                } else {
                    stack.pop();
                }
            }
            if (!crashed) stack.push(a);
        }
        int[] ans = new int[stack.size()];

        int j = stack.size() - 1;
        while (j >= 0) {
            ans[j] = stack.pop();
            j--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ast = new int[]{5, 10, -5};
        Solution735 sol = new Solution735();
        int[] ans = sol.asteroidCollision(ast);
        for (Integer a: ans) {
            System.out.println(a);
        }
    }
}
