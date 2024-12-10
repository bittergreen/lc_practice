package stack;

import java.util.Deque;
import java.util.LinkedList;

// 739. Daily Temperatures
public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] res = new int[temperatures.length];
        // storing {number, position}
        Deque<int[]> stack = new LinkedList<>();

        for (int i=0; i<temperatures.length; i++) {
            int t = temperatures[i];
            if (stack.isEmpty() || t <= stack.peek()[0]) {
                int[] tmp = {t, i};
                stack.push(tmp);
            }
            while (!stack.isEmpty() && t > stack.peek()[0]) {
                int[] tmp = stack.pop();
                int pos = tmp[1];
                res[pos] = i - pos;
            }
            // push this element at last
            int[] tmp = {t, i};
            stack.push(tmp);
        }
        return res;
    }
}
