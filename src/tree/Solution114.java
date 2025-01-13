// 114. 二叉树展开为链表

package tree;

public class Solution114 {
    public void flatten(TreeNode root) {
        if (root == null) return;

        // 递归处理当前节点，展开左右子树
        flatten(root.left);
        flatten(root.right);

        // 如果左子树不为空，则将左子树移到右子树的位置
        if (root.left != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;

            // 递归找到原来右子树的末尾，并连接到它
            TreeNode current = root.right;
            while (current.right != null) {
                current = current.right;
            }
            current.right = temp;
        }
    }
}
