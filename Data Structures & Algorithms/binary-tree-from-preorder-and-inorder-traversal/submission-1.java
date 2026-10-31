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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        var pre = Arrays.stream(preorder).boxed().toList();
        var ino = Arrays.stream(inorder).boxed().toList();
        return build(pre, ino);
    }

    private TreeNode build(List<Integer> preorder, List<Integer> inorder) {
        if (preorder.isEmpty() || inorder.isEmpty()) {
            return null;
        }

        TreeNode root = new TreeNode(preorder.get(0));
        int mid = inorder.indexOf(root.val);

        root.left = build(preorder.subList(1, mid + 1), 
                            inorder.subList(0, mid));

        root.right = build(preorder.subList(mid + 1, preorder.size()), 
                            inorder.subList(mid + 1, preorder.size()));

        return root;
    }

}
