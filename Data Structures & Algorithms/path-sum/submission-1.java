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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        Stack<TreeNode> nodes = new Stack();
        Stack<Integer> sums = new Stack();
        nodes.push(root);
        sums.push(targetSum);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            int sum = sums.pop();

            if (node.left == null && node.right == null
                && sum - node.val == 0) return true; 

            if (node.left != null) {
                nodes.push(node.left);
                sums.push(sum - node.val);
            }

            if (node.right != null) {
                nodes.push(node.right);
                sums.push(sum - node.val);
            }
        }

        return false;
    }
}