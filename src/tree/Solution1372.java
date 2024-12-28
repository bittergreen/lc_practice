// 1372. 二叉树中的最长交错路径

package tree;

public class Solution1372 {
    private int maxLength;

    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0);
        return maxLength;
    }

    public void dfs(TreeNode node, boolean wasLeft, int curLength) {
        if (node == null) return;
        maxLength = Math.max(maxLength, curLength);
        if (wasLeft) {
            dfs(node.left, true, 1);
            dfs(node.right, false, curLength + 1);
        } else {
            dfs(node.left, true, curLength + 1);
            dfs(node.right, false, 1);
        }
        return;
    }
}
