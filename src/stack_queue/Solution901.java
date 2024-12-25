// 901. 股票价格跨度
package stack_queue;

import java.util.Deque;
import java.util.LinkedList;

public class Solution901 {
    class StockSpanner {

        private Deque<int[]> stack = new LinkedList<>();  // {day, price}
        private int curDay = -1;

        public StockSpanner() {
            stack.push(new int[]{-1, Integer.MAX_VALUE});
        }

        public int next(int price) {
            curDay++;
            while (price >= stack.peek()[1]) {
                stack.pop();
            }
            int span = curDay - stack.peek()[0];
            stack.push(new int[]{curDay, price});
            return span;
        }
    }
}
