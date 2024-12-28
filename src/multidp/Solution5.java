// 5. 最长回文子串
package multidp;

public class Solution5 {

    public String longestPalindrome(String s) {
        // dp[l][r] = true if s[l] == s[r] && dp[l+1][r-1]
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLength = 1;
        int left = 0;
        int right = 0;

        for (int r = 1; r < n; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l+1][r-1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLength) {
                        maxLength = r - l + 1;
                        left = l;
                        right = r;
                    }
                }
            }
        }

        return s.substring(left, right+1);
    }
    
}
