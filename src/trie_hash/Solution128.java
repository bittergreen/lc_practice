// 128. 最长连续序列

package trie_hash;

import java.util.*;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        // build the set
        for (int num: nums) {
            set.add(num);
        }

        int maxLength = 1;
        for (int num: nums) {
            if (!set.contains(num - 1)) {
                int curLength = 1;
                while (set.contains(num + 1)) {
                    num++;
                    curLength++;
                    maxLength = Math.max(maxLength, curLength);
                }
            }
        }
        return maxLength;
    }
}
