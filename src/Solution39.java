import java.util.HashSet;
import java.util.Set;

// 73. Set Matrix Zeroes
public class Solution39 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (rowSet.contains(i) || colSet.contains(j)) matrix[i][j] = 0;
            }
        }
    }

    public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 1st row, 1st col used to record for 1st row
        boolean firstRow = false;
        boolean firstCol = false;

        for (int k=0; k<n; k++) {
            if (matrix[0][k] == 0) {
                firstRow = true;
                break;
            }
        }

        for (int k=0; k<m; k++) {
            if (matrix[k][0] == 0) {
                firstCol = true;
                break;
            }
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        for (int k=0; k<n; k++) {
            if (firstRow) {
                matrix[0][k] = 0;
            }
        }
        for (int k=0; k<m; k++) {
            if (firstCol) {
                matrix[k][0] = 0;
            }
        }
    }

}
