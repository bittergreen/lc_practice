// 994. 腐烂的橘子

package graph;

import java.util.*;

public class Solution994 {

    int cnt;
    int M;
    int N;
    int[][] grid;

    public int orangesRotting(int[][] grid) {
        this.grid = grid;
        Queue<int[]> rotten = new ArrayDeque<>();
        M = grid.length;
        N = grid[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int status = grid[i][j];
                if (status == 1) cnt++;
                if (status == 2) rotten.offer(new int[]{i, j});
            }
        }
        if (cnt == 0) return 0;

        int minute = 0;
        while (!rotten.isEmpty()) {
            int n = rotten.size();
            // bfs
            for (int k = 0; k < n; k++) {
                int[] tmp = rotten.poll();
                int i = tmp[0];
                int j = tmp[1];
                rot(i, j, rotten);
            }
            minute++;
        }

        return cnt == 0 ? minute - 1 : -1;
    }

    public void rot(int i, int j, Queue<int[]> rotten) {
        int[][] nextIds = {{i + 1, j}, {i - 1, j}, {i, j + 1}, {i, j - 1}};
        for (int[] next: nextIds) {
            int nextI = next[0];
            int nextJ = next[1];
            if (nextI >= 0 && nextI < M && nextJ >= 0 &&
                    nextJ < N && grid[nextI][nextJ] == 1) {
                grid[nextI][nextJ] = 2;
                rotten.offer(new int[]{nextI, nextJ});
                cnt--;
            }
        }
        return;
    }

}
