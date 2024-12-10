package dp;

import java.util.HashMap;
import java.util.Map;

// 70.Climbing stairs
public class Solution41 {
    public int climbStairs(int n) {
        Map<Integer, Integer> memory = new HashMap<>();
        return climb(n, memory);
    }

    int climb(int n, Map<Integer, Integer> memory) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (memory.containsKey(n)) return memory.get(n);
        int res = climb(n-1, memory) + climb(n-2, memory);
        memory.put(n, res);
        return res;
    }

    public int climbStairsDP(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int a = 1;
        int b = 2;
        for (int i=2; i<n; i++) {
            int tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }

}
