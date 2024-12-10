package search;

// 74. Search a 2D Matrix
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // m x n matrix
        int m = matrix.length;
        int n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m-1][n-1]) return false;
        // search vertically -> search horizontally
        int small = 0;
        int big = m-1;
        // vertical search
        while (big > small) {
            int mid = (small + big) / 2;
            if (target == matrix[mid][0]) {
                return true;
            } else if (target > matrix[mid][0]) {
                small = mid + 1;
            } else {
                big = mid - 1;
            }
        }
        int verticalIndex = (matrix[small][0] > target) ? small-1 : small;
        small = 0;
        big = n-1;
        // horizontal search
        while (big > small) {
            int mid = (small + big) / 2;
            if (target == matrix[verticalIndex][mid]) {
                return true;
            } else if (target > matrix[verticalIndex][mid]) {
                small = mid + 1;
            } else {
                big = mid - 1;
            }
        }
        int horizontalIndex = small;
        return (matrix[verticalIndex][horizontalIndex] == target);
    }

    public static void main(String[] args) {
        int[][] m = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        Solution74 sol = new Solution74();
        System.out.println(sol.searchMatrix(m, 11));
    }
}
