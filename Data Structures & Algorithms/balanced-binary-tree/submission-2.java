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
        int lh = calculateHeight(root.left, 0);
        int rh = calculateHeight(root.right, 0);
        int differ = Math.abs(lh - rh);
        return differ <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int calculateHeight(TreeNode root, int curH) {
        if (root == null) {
            return curH;
        }
        curH += 1;
        int lh = calculateHeight(root.left, curH);
        int rh = calculateHeight(root.right, curH);
        return Math.max(lh, rh);
    }
}
