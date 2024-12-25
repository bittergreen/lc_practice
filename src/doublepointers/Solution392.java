// 392. 判断子序列
package doublepointers;

public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            char curMatch = s.charAt(i);
            while (j < t.length() && t.charAt(j) != curMatch) {
                j++;
            }
            if (j == t.length()) return false;
            i++;
            j++;
        }
        return true;
    }
}
