package backtracking;

import java.util.ArrayList;
import java.util.List;

// 22. Generate Parentheses
public class Solution49 {

    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    int genLeft = 0;
    int genRight = 0;
    int max;

    public List<String> generateParenthesis(int n) {
        // only when left > right can we generate right parentheses
        if (n == 0) return res;
        this.max = n;
        dfs();
        return res;
    }

    void dfs() {
        if (genLeft == max && genRight == max) {
            res.add(new String(path));
            return;
        }

        if (genLeft <= genRight) {
            // have no other choice
            path.append("(");
            genLeft++;
            dfs();
            genLeft--;
            path.deleteCharAt(path.length()-1);
        } else if (genLeft == max) {
            // have no other choice
            path.append(")");
            genRight++;
            dfs();
            genRight--;
            path.deleteCharAt(path.length()-1);
        } else {
            path.append("(");
            genLeft++;
            dfs();
            genLeft--;
            path.deleteCharAt(path.length()-1);
            path.append(")");
            genRight++;
            dfs();
            genRight--;
            path.deleteCharAt(path.length()-1);
        }
    }

    public static void main(String[] args) {
        Solution49 sol = new Solution49();
        System.out.println(sol.generateParenthesis(3));
    }
}
