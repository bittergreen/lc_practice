import java.util.HashMap;
import java.util.Map;

// 3. 无重复字符的最长子串
public class Solution14 {

    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int left = -1;
        int maxLength = 0;

        for (int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(map.get(s.charAt(i)), left);
            }
            map.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - left);
        }

        return maxLength;

    }

    public static void main(String[] args) {
        Solution14 sol = new Solution14();
        String s = "abba";
        sol.lengthOfLongestSubstring(s);
    }
}
