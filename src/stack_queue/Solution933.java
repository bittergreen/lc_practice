// 933. 最近的请求次数

package stack_queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution933 {
}

class RecentCounter {

    private final int RANGE = 3000;
    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<Integer>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (t - queue.peek() > 3000) {
            queue.poll();
        }
        return queue.size();
    }
}
