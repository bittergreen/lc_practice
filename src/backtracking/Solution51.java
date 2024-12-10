package backtracking;

// 79. Word Search
public class Solution51 {

    char[][] board;
    int verticalBound;
    int horizontalBound;
    boolean[][] visited;
    String word;
    Boolean res = false;


    public boolean exist(char[][] board, String word) {
        verticalBound = board.length;
        horizontalBound = board[0].length;
        this.board = board;
        this.word = word;
        visited = new boolean[verticalBound][horizontalBound];

        if (word.isEmpty()) return true;

        for (int i=0; i<verticalBound; i++) {
            for (int j=0; j<horizontalBound; j++) {
                res = dfs(0, i, j);
                if (res) return true;
            }
        }

        return res;
    }

    boolean dfs(int depth, int x, int y) {
        // breaking
        if (y >= horizontalBound || y < 0 || x >= verticalBound || x < 0 || board[x][y] != word.charAt(depth)) return false;
        if (visited[x][y]) return false;
        if (depth == word.length()-1) return true;
        // if (path.length() > 1 && !path.toString().equals(word.substring(0, path.length()))) return;

        visited[x][y] = true;
        boolean res = (
                dfs(depth+1, x, y+1) ||
                dfs(depth+1, x, y-1) ||
                dfs(depth+1, x+1, y) ||
                dfs(depth+1, x-1, y)
        );
        visited[x][y] = false;

        return res;
    }

    public static void main(String[] args) {
        Solution51 sol = new Solution51();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        // char[][] board = {{'A'}};
        // String word = "A";
        // char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        // String word = "ABCB";
        System.out.println(sol.exist(board, word));
        
    }
}
