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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int lh = calculateHeight(root.left);
        int rh = calculateHeight(root.right);
        int differ = Math.abs(lh - rh);
        return differ <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = calculateHeight(root.left);
        int rh = calculateHeight(root.right);
        return 1 + Math.max(lh, rh);
    }
}
