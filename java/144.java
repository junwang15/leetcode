public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)    return result;
        result.add(root.val);
        dfs(result, root);
        return result;
    }
    
    private void dfs(List<Integer> result, TreeNode root) {
        if(root == null)
            return;
        if(root.left != null) {
            result.add(root.left.val);
            dfs(result, root.left);
        }
        if(root.right != null) {
            result.add(root.right.val);
            dfs(result, root.right);
        }
    }
}
