package stack;

import java.util.Deque;
import java.util.LinkedList;

// 20. Valid Parentheses
public class Solution20 {

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                Character top = stack.pop();
                if (!match(c, top)) {
                    stack.push(top);
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }

    boolean match(Character a, Character b) {
        if (a == ')') {
            return b == '(';
        }
        if (a == ']') {
            return b == '[';
        }
        if (a == '}') {
            return b == '{';
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        Solution20 sol = new Solution20();
        System.out.println(sol.isValid(s));
    }
}
