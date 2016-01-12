/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
An example is the root-to-leaf path 1->2->3 which represents the number 123.
Find the total sum of all root-to-leaf numbers.
For example,
    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Return the sum = 12 + 13 = 25.
*/

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
