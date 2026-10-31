/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    private int count;
    private int res;

    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        this.res = 0;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        if (node == null || count == 0) {
            return;
        }

        dfs(node.left);

        --count;
        if (count == 0) {
            res = node.val;
            return;
        }

        dfs(node.right);
    }
}
