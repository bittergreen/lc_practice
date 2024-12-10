package tree;

// 101. 对称二叉树
public class Solution24 {

    public boolean isSymmetric(TreeNode root) {
        return (root == null || recur(root.left, root.right));
    }

    private boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return recur(left.left, right.right) && recur(left.right, right.left);
    }
}
