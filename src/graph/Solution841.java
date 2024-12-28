// 841. 钥匙和房间

package graph;

import java.util.*;

public class Solution841 {

    Map<Integer, List<Integer>> graph;
    boolean[] visited;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        graph = new HashMap<>();
        // build adjacency list
        for (int i = 0; i < rooms.size(); i++) {
            graph.put(i, rooms.get(i));
        }
        visited = new boolean[rooms.size()];

        dfs(0);

        for (boolean v: visited) {
            if (!v) return false;
        }
        return true;
    }

    public void dfs(int room) {
        if (visited[room]) return;
        visited[room] = true;
        List<Integer> neighbors = graph.get(room);
        for (int nei: neighbors) {
            dfs(nei);
        }
        return;
    }

}
