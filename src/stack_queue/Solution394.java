package stack_queue;

import java.util.Deque;
import java.util.LinkedList;

// 394. Decode String
public class Solution394 {
    public String decodeString(String s) {
        StringBuilder curStr = new StringBuilder();
        int curNum = 0;
        Deque<Integer> lenStack = new LinkedList<>();
        Deque<String> strStack = new LinkedList<>();

        for (char ch: s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                curNum = 10 * curNum + Integer.parseInt(String.valueOf(ch));
            } else if (ch == '[') {
                strStack.push(curStr.toString());
                lenStack.push(curNum);
                curStr = new StringBuilder();
                curNum = 0;
            } else if (ch == ']') {
                int lastNum = lenStack.pop();
                String lastStr = strStack.pop();
                curStr = new StringBuilder(lastStr + curStr.toString().repeat(lastNum));
            } else {
                curStr.append(ch);
            }
        }

        return curStr.toString();
    }

    public static void main(String[] args) {
        Solution394 s = new Solution394();
        String input = "3[a]2[bc]";
        System.out.println(s.decodeString(input));
    }
}
