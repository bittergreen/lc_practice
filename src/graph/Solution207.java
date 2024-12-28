// 207. 课程表

package graph;

import java.util.*;

public class Solution207 {

    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build graph
        for (int[] prerequisite : prerequisites) {
            int ai = prerequisite[0];
            int bi = prerequisite[1];
            List<Integer> tmp = graph.getOrDefault(ai, new ArrayList<>());
            tmp.add(bi);
            graph.put(ai, tmp);
        }
        visited = new int[numCourses];  // 0 -> unvisited, 1 -> visited, 2 -> visiting

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return false;
        }

        return true;
    }

    public boolean dfs(int course) {
        if (visited[course] == 1) return true;
        if (visited[course] == 2) return false;
        List<Integer> pres = graph.get(course);
        if (pres == null) return true;
        visited[course] = 2;
        for (int pre : pres) {
            if (!dfs(pre)) {
                return false;
            }
        }
        visited[course] = 1;
        return true;
    }

    public static void main(String[] args) {
        int num = 2;
        int[][] pre = {{1, 0}};
        Solution207 sol = new Solution207();
        System.out.println(sol.canFinish(2, pre));
    }

}
