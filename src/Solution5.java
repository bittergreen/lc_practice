import java.util.HashMap;
import java.util.Map;

// 169. 多数元素
public class Solution5 {

    public int majorityElement1(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            int v = map.getOrDefault(num, 0);
            map.put(num, v+1);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > nums.length/2) {
                res = entry.getKey();
                break;
            }
        }

        for (Integer a: map.keySet()) {
            int v = map.get(a);
            if (v > nums.length/2) {
                res = a;
            }
        }

        return res;
    }

    public int majorityElement(int[] nums) {

        int vote = 0, res = Integer.MAX_VALUE;
        for (int num: nums) {
            if (vote == 0) res = num;
            vote += num == res ? 1 : -1;
        }
        return res;
    }
}
