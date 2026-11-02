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
        
        Queue<TreeNode> nodes = new ArrayDeque<>();
        Queue<Integer> sums = new ArrayDeque<>();
        nodes.offer(root);
        sums.offer(targetSum - root.val);

        while (!nodes.isEmpty()) {
            int levelSize = nodes.size();
            for (int i = 0; i < levelSize; ++i) {
                TreeNode node = nodes.remove();

                int sum = sums.remove();
                if (node.left == null && node.right == null &&
                    sum == 0) return true;

                if (node.left != null) {
                    nodes.offer(node.left);
                    sums.offer(sum - node.left.val);
                }
                if (node.right != null) {
                    nodes.offer(node.right);
                    sums.offer(sum - node.right.val);
                }
            }
        }

        return false;
    }
}