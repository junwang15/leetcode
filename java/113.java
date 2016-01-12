package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 * @author jun
 *
 */

public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        List<Integer> path = new ArrayList<Integer>();
        path.add(root.val);
        pathSum(root, sum-root.val, result, path);
        return result;
    }
    
    private void pathSum(TreeNode root, int sum, List<List<Integer>> result, List<Integer> path) {
        if(root.left == null && root.right == null && sum == 0) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.addAll(path);
            result.add(temp);
            return;
        }

        if(root.left != null) {
            path.add(root.left.val);
            pathSum(root.left, sum-root.left.val, result, path);
            path.remove(path.size() - 1);
        }  
        if(root.right != null) {
            path.add(root.right.val);
            pathSum(root.right, sum-root.right.val, result, path);
            path.remove(path.size() - 1);
        }
    }
}
