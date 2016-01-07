public class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0, 0);
    }
    
    private int sumNumbers(TreeNode p, int sum, int num) {
        if(p == null)
            return 0;
        num = num*10 + p.val;
        // p is a leaf
        if(p.left == null && p.right == null)
            return sum += num;
        // p is an intermedian node
        return sumNumbers(p.left, sum, num) + sumNumbers(p.right, sum, num);
    }
}
