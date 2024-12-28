// 199. 二叉树的右视图
package tree;

import java.util.*;

public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            TreeNode tmp = new TreeNode();
            for (int i = 0; i < n; i++) {
                tmp = queue.poll();
                if (tmp.left != null) queue.offer(tmp.left);
                if (tmp.right != null) queue.offer(tmp.right);
            }
            // tmp is the rightmost node
            ans.add(tmp.val);
        }

        return ans;
    }
}
