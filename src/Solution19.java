import java.util.HashMap;
import java.util.Map;

// 76. 最小覆盖子串
public class Solution19 {

    public String minWindow(String s, String t) {

        Map<Character, Integer> cntMap = new HashMap<>();
        for (int i=0; i<t.length(); i++) {
            Character ch = t.charAt(i);
            int cnt = cntMap.getOrDefault(ch, 0);
            cntMap.put(ch, cnt+1);
        }

        int reservedLeft = -1;
        int reservedRight = -1;
        int minLength = s.length() + 1;
        int left = -1;
        int right = -1;
        Map<Character, Integer> slidingMap = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            Character ch = s.charAt(i);
            int cnt = slidingMap.getOrDefault(ch, 0);
            slidingMap.put(ch, cnt+1);
            while (mapContains(slidingMap, cntMap)) {
                right = i;
                left ++;
                slidingMap.replace(s.charAt(left), slidingMap.get(s.charAt(left))-1);
                if (right - left < minLength) {
                    minLength = right - left;
                    reservedRight = right;
                    reservedLeft = left;
                }
            }
        }

        return reservedLeft < 0 ? "" : s.substring(reservedLeft, reservedRight+1);

    }

    private boolean mapContains(Map<Character, Integer> map1, Map<Character, Integer> map2) {

        boolean res = true;
        for (Map.Entry<Character, Integer> entry: map2.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (map1.getOrDefault(key, 0) < value) {
                res = false;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Solution19 sol = new Solution19();
        String res = sol.minWindow(s, t);
        System.out.println(res);
    }

}
