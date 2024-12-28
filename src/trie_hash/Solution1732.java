// 1732. 找到最高海拔
package trie_hash;

public class Solution1732 {
    public int largestAltitude(int[] gain) {
        int prefixSum = 0;
        int max = 0;
        for (int i = 0; i < gain.length; i++) {
            prefixSum += gain[i];
            max = Math.max(prefixSum, max);
        }

        return max;
    }

}
