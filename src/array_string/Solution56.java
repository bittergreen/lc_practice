package array_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 56. Merge Intervals
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        // [[1,3],[2,6],[8,10],[15,18]]
        Arrays.sort(intervals, (p, q) -> p[0] - q[0]);
        List<int[]> res = new ArrayList<>();

        int left = -1;
        int right = -1;
        for (int[] elem: intervals) {
            int newLeft = elem[0];
            int newRight = elem[1];
            if (newLeft <= right) {
                right = Math.max(right, newRight);
            } else {
                if (left >= 0) {
                    int[] tmp = {left, right};
                    res.add(tmp);
                }
                left = newLeft;
                right = newRight;
            }
        }
        // add the last
        int[] tmp = {left, right};
        res.add(tmp);
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] test = {{1,3},{2,6},{8,10},{15,18}};
        Solution56 sol = new Solution56();
        sol.merge(test);
    }
}
