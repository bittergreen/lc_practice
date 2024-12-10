import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 438. Find All Anagrams in a String
public class Solution33 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;

        int windowLength = p.length();
        int[] cnt = new int[26];

        // count letters in p
        for (int i=0; i<p.length(); i++) {
            cnt[p.charAt(i) - 'a']++;
        }

        int r = -1;
        for (int i=0; i<windowLength; i++) {
            cnt[s.charAt(r+1) - 'a']--;
            r++;
        }

        // slide window over s, find p
        for (int l=0; l<s.length()-windowLength+1; l++) {
            if (allZero(cnt)) {
                res.add(l);
            }
            // slide 1 step
            cnt[s.charAt(l) - 'a']++;
            r++;
            if (r < s.length()) cnt[s.charAt(r) - 'a']--;
        }
        return res;
    }

    boolean allZero(int[] checked) {
        boolean res = true;
        for (int num: checked) {
            if (num != 0) {
                res = false;
                break;
            }
        }
        return res;
    }
}
