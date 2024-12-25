package stack_queue;

// 155. Min Stack

import java.util.*;

class MinStack {

    Deque<Integer> stack;
    Deque<Integer> min_stack;

    public MinStack() {
        this.stack = new LinkedList<>();
        this.min_stack = new LinkedList<>();
    }

    public void push(int val) {
        if (min_stack.isEmpty() || val <= min_stack.peek()) {
            min_stack.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        if (Objects.equals(min_stack.peek(), stack.pop())) {
            min_stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }
}


public class Solution155 {
}
