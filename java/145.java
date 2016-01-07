public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        dfs(result, root);
        return result;
    }
    
    private void dfs(List<Integer> result, TreeNode root) {
        if(root == null)
            return;
        if(root.left != null)
            dfs(result, root.left);
        if(root.right != null)
            dfs(result, root.right);
        result.add(root.val);
    }
}
