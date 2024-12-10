package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 17. Letter Combinations of a Phone Number


public class Solution47 {

    Map<Character, String> map = new HashMap<>();
    List<String> res = new ArrayList<>();
    StringBuilder str = new StringBuilder();
    String digits;


    public List<String> letterCombinations(String digits) {
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        if (digits.isEmpty()) return res;

        this.digits = digits;
        dfs(0);
        return res;
    }

    void dfs(int depth) {

        if (depth == digits.length()) {
            res.add(new String(str));
            return;
        }

        Character ch = digits.charAt(depth);
        String candidate = map.get(ch);
        for (int i=0; i<candidate.length(); i++) {
            str.append(candidate.charAt(i));
            dfs(depth+1);
            str.deleteCharAt(str.length()-1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        Solution47 sol = new Solution47();
        System.out.println(sol.letterCombinations(digits));
    }
}
