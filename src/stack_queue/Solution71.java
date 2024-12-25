// 71. 简化路径
package stack_queue;

import java.util.Deque;
import java.util.LinkedList;

public class Solution71 {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        int numPoints;

        // build the stack of directories
        for (String dir: path.split("/")) {
            if (dir.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!dir.isEmpty() && !dir.equals(".")) {
                stack.push(dir);
            }
        }

        String res = "";
        for (String s: stack) {
            res = "/" + s + res;
        }
        return res.isEmpty() ? "/" : res;
    }

    public static void main(String[] args) {
        String path = "/home/bad/";
        Solution71 sol = new Solution71();
        String res = sol.simplifyPath(path);
        System.out.println(res);
    }
}
