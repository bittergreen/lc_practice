package stack;

import java.util.Deque;
import java.util.LinkedList;

// 394. Decode String
public class Solution394 {
    public String decodeString(String s) {
        Deque<StringBuilder> stack = new LinkedList<>();
        Deque<Integer> cntStack = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        for (Character c: s.toCharArray()) {
            if ('0' <= c && c <= '9') {
                int now = Integer.parseInt(c + "");
                if (cntStack.size() > stack.size()) {
                    // meaning that we need to add 1
                    int last = cntStack.pop();
                    now = last * 10 + now;
                }
                cntStack.push(now);

            } else if (c == '[') {
                stack.push(new StringBuilder());

            } else if (c == ']') {
                StringBuilder tmp = stack.pop();
                int times = cntStack.pop();
                if (stack.isEmpty()) {
                    // directly append to res
                    for (int i=0; i<times; i++) {
                        res.append(tmp);
                    }
                } else {
                    // append to some stacked tmp strings
                    StringBuilder last = stack.pop();
                    for (int i=0; i<times; i++) {
                        last.append(tmp);
                    }
                    stack.push(last);
                }

            } else {
                if (!stack.isEmpty()) {
                    StringBuilder tmp = stack.pop();
                    tmp.append(c);
                    stack.push(tmp);
                } else {
                    res.append(c);
                }

            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution394 s = new Solution394();
        String input = "3[a]2[bc]";
        System.out.println(s.decodeString(input));
    }
}
