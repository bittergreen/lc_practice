package tree;

import java.util.ArrayList;
import java.util.List;

// 94. 二叉树的中序遍历
public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;

    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

}
