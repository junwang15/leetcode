public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }
    
    private boolean isValidBST(TreeNode root, double max, double min) {
        if(root == null)    return true;
        if(root.val >= max || root.val <= min)
            return false;
        return isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
    }
}
