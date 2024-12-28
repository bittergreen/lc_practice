// 49. 字母异位词分组

package trie_hash;

import java.util.*;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> store = new HashMap<>();
        for (String str: strs) {
            char[] sorted = str.toCharArray();
            Arrays.sort(sorted);
            String sortedStr = new String(sorted);
            List<String> tmp = store.getOrDefault(sortedStr, new ArrayList<String>());
            tmp.add(str);
            store.put(sortedStr, tmp);
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> value: store.values()) {
            ans.add(value);
        }
        return ans;
    }
}
