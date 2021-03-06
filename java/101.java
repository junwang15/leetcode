/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 */
 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
// recursive solution
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode p, TreeNode q) {
        if(p == null && q == null)  return true;
        if(p == null || q == null)  return false;
        return p.val == q.val && helper(p.left, q.right) && helper(p.right, q.left);
    }
}
