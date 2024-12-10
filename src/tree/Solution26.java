package tree;// 102.二叉树的层序遍历

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// 102. 二叉树的层序遍历
public class Solution26 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if (root != null) que.add(root);
        while (!que.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i=que.size(); i>0; i--) {
                TreeNode node = que.poll();
                tmp.add(node.val);
                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
