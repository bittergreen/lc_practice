// 2390. 从字符串中移除星号
package stack_queue;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2390 {
    public String removeStars(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                ans.deleteCharAt(ans.length() - 1);
            }
            else {
                ans.append(c);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}
