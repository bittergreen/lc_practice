import java.util.ArrayList;
import java.util.List;

// 54. Spiral Matrix
public class Solution40 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0, right = matrix[0].length-1, up = 0, down = matrix.length-1;
        int posX = 0, posY = 0;
        List<Integer> res = new ArrayList<>();
        res.add(matrix[posX][posY]);
        while (true) {
            // mv right
            while (posY < right) {
                posY++;
                res.add(matrix[posX][posY]);
            }
            up++;
            if (up > down) break;
            // mv down
            while (posX < down) {
                posX++;
                res.add(matrix[posX][posY]);
            }
            right--;
            if (left > right) break;
            // mv left
            while (posY > left) {
                posY--;
                res.add(matrix[posX][posY]);
            }
            down--;
            if (up > down) break;
            // mv top
            while (posX > up) {
                posX--;
                res.add(matrix[posX][posY]);
            }
            left++;
            if (left > right) break;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution40 sol = new Solution40();
        // int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] matrix = {{3},{2}};
        sol.spiralOrder(matrix);
    }
}
