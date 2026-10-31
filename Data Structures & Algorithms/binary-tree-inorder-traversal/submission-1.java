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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();
        var curr = root;
        while(curr != null || !nodes.isEmpty()) {
            while (curr != null) {
                nodes.add(curr);
                curr = curr.left;
            }
            curr = nodes.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}