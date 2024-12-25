package heap;

import java.util.PriorityQueue;

public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int i: nums) {
            heap.offer(i);
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = heap.poll();
        }
        return ans;
    }
}
