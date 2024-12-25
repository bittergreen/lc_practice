// 347. 前 K 个高频元素
package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occur = new HashMap<>();
        for (int num: nums) {
            occur.put(num, occur.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for (Map.Entry<Integer, Integer> entry: occur.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            heap.offer(new int[]{key, value});
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll()[0];
        }

        return ans;
    }
}
