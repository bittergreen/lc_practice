package stack_queue;

import java.util.Deque;
import java.util.LinkedList;

// 739. Daily Temperatures
public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && t > temperatures[stack.peek()]) {
                int pos = stack.pop();
                ans[pos] = i - pos;
            }
            stack.push(i);
        }

        return ans;
    }
}
