import java.util.HashMap;
import java.util.Map;

// 128. Longest Consecutive Sequence
public class Solution29 {

    public int longestConsecutive(int[] nums) {
        int max_length = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer number: nums) {
            if (!map.containsKey(number)) {
                int left = map.getOrDefault(number - 1, 0);
                int right = map.getOrDefault(number + 1, 0);
                int curLength = left + right + 1;
                max_length = Math.max(max_length, curLength);
                map.put(number, curLength);
                map.put(number - left, curLength);
                map.put(number + right, curLength);
            }
        }
        return max_length;
    }
}
