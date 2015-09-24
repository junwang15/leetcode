/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
    
    private void invert(TreeNode n) {
        if(n == null) return;
        TreeNode tmp = n.left;
        n.left = n.right;
        n.right = tmp;
        invert(n.left);
        invert(n.right);
    }
}
