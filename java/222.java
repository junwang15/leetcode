// In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

public class Solution {
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int leftMostHeight = 0, rightMostHeight = 0;
        TreeNode temp = root;
        while(temp != null) {
            leftMostHeight++;
            temp = temp.left;
        }
        temp = root;
        while(temp != null) {
            rightMostHeight++;
            temp = temp.right;
        }
        if(leftMostHeight == rightMostHeight)
            return (1 << leftMostHeight) - 1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
