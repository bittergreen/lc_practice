package dp;

// 279. Perfect Squares
public class Solution44 {
    public int numSquares(int n) {
        // dp: least numbers added nums
        // dp[i] = min(dp[i], dp[i-j*j] + 1)
        int[] dp = new int[n+1];
        for (int i=0; i<dp.length; i++) {
            dp[i] = i;
            for (int j=1; j*j<=i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution44 sol = new Solution44();
        System.out.println(sol.numSquares(12));
    }
}
