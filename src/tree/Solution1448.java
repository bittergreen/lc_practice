// 1448. 统计二叉树中好节点的数目
package tree;

public class Solution1448 {

    int num = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, root.val - 1);
        return num;
    }

    public void dfs(TreeNode node, int maxValue) {
        if (node == null) return;
        if (node.val >= maxValue) num++;
        dfs(node.left, Math.max(maxValue, node.val));
        dfs(node.right, Math.max(maxValue, node.val));
    }

}
