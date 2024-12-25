// 2462. 雇佣 K 位工人的总代价
package heap;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution2462 {

    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long ans = 0;
        if (2 * candidates + k > n) {
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                ans += costs[i];
            }
            return ans;
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));

        int left = 0;
        int right = n - 1;

        for (; left < candidates; left++) {
            heap.offer(new int[]{costs[left], left});
        }
        for (; right >= n - candidates; right--) {
            heap.offer(new int[]{costs[right], right});
        }

        for (int i = 0; i < k; i++) {
            int[] elem = heap.poll();
            ans += elem[0];
            if (elem[1] < left) {
                // left add elem
                heap.offer(new int[]{costs[left], left});
                left++;
            } else {
                // right add elem
                heap.offer(new int[]{costs[right], right});
                right--;
            }
        }
        return ans;
    }

}
