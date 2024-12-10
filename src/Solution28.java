import java.util.*;

public class Solution28 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> store = new HashMap<>();  // key: sorted str, value: words
        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> stored = store.getOrDefault(key, new ArrayList<>());
            stored.add(str);
            store.put(key, stored);  // update
        }
        return new ArrayList<>(store.values());
    }

    public static void main(String[] args) {
        System.out.println("SHit");
    }
}
