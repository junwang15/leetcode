// binary tree inorder traversal

// recursive
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)    return result;
        dfs(result, root);
        return result;
    }
    
    private void dfs(List<Integer> result, TreeNode root) {
        if(root == null)    
            return;
        if(root.left != null)
            dfs(result, root.left);
        result.add(root.val);
        if(root.right != null)
            dfs(result, root.right);
    }
}

// iterative
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        if(root == null)    
            return result;
            
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode p = root;
        
        while(!stk.isEmpty() || p != null) {
            if(p != null) {
                stk.push(p);
                p = p.left;
            } else {
                TreeNode t = stk.pop();
                result.add(t.val);
                p = t.right;
            }
        }
        return result;
    }
}
