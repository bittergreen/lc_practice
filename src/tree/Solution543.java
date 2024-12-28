// 543. 二叉树的直径

package tree;

public class Solution543 {
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDiameter;
    }

    public int depth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        int diameter = leftDepth + rightDepth;
        maxDiameter = Math.max(maxDiameter, diameter);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
