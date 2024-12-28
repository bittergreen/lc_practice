package trie_hash;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> store = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (store.containsKey(nums[i])) {
                return new int[]{store.get(nums[i]), i};
            }
            store.put(target - nums[i], i);
        }
        return new int[2];
    }
}
