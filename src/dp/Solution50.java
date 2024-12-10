package dp;// 322. Coin Change

import java.util.ArrayList;
import java.util.List;

public class Solution50 {

    int total;
    int curSum;
    int[] coins;
    List<Integer> path;
    int[] dp;

    public int coinChange(int[] coins, int amount) {
        // dp[i] = Math.min(dp[i], dp[i-coins[j]+1)
        if (amount == 0) return 0;
        if (coins.length == 0) return -1;
        this.coins = coins;
        this.dp = new int[amount+1];
        // initialize
        for (int i=1; i<amount+1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i=1; i<=amount; i++) {
            for (int j=0; j<coins.length; j++) {
                if (i >= coins[j] && dp[i-coins[j]] < dp[i]) {
                    dp[i] = dp[i-coins[j]] + 1;
                }
            }
        }

        int res = dp[dp.length-1];
        if (res == Integer.MAX_VALUE) res = -1;
        return res;
    }

    public int coinChangeBackTracking(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins.length == 0) return -1;
        this.coins = coins;
        this.dp = new int[amount+1];
        // initialize
        for (int i=0; i<amount+1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i=1; i<amount+1; i++) {
            this.total = amount;
            path = new ArrayList<>();
            dfs(0);
        }
        int res = dp[dp.length-1];
        if (res == Integer.MAX_VALUE) res = -1;
        return res;
    }

    void dfs(int depth) {

        if (depth == coins.length || curSum >= total) {
            if (total == curSum && !path.isEmpty()) {
                dp[total] = Math.min(dp[total], path.size());
            }
            return;
        }

        for (int i=depth; i<coins.length; i++) {
            int now = coins[i];
            path.add(now);
            curSum += now;
            dfs(i);
            curSum -= now;
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        Solution50 sol = new Solution50();
        int[] coins = {186,419,83,408};
        int amount = 6249;
        System.out.println(sol.coinChange(coins, amount));
    }
}
