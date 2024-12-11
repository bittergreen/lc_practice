package dp;// 118. Pascal's Triangle
import java.util.*;

public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        // dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
        List<List<Integer>> res = new ArrayList<>(numRows);
        res.add(List.of(1));
        for (int i=1; i<numRows; i++) {
            List<Integer> layer = new ArrayList<>(i+1);
            layer.add(1);
            for (int j=1; j<i; j++) {
                layer.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
            }
            layer.add(1);
            res.add(layer);
        }
        return res;
    }

}
