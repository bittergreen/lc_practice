package stack_queue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

// 20. Valid Parentheses
public class Solution20 {

    public boolean isValid(String s) {
        HashMap<Character, Character> match = new HashMap<>();
        match.put(')', '(');
        match.put(']', '[');
        match.put('}', '{');
        Deque<Character> stack = new LinkedList<>();

        for (char ch: s.toCharArray()) {
            if (stack.isEmpty() || !match.containsKey(ch)) {
                stack.push(ch);
            } else {
                Character top = stack.pop();
                if (match.get(ch) != top) {
                    stack.push(top);
                    stack.push(ch);
                }
            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String s = "()[]{}";
        Solution20 sol = new Solution20();
        System.out.println(sol.isValid(s));
    }
}
