/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
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
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        boolean levelIsOdd = false;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> listMember = new ArrayList<Integer>();
            for(int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                listMember.add(temp.val);
                if(temp.left != null)   q.offer(temp.left);
                if(temp.right != null)  q.offer(temp.right);
            }
            if(levelIsOdd)
                Collections.reverse(listMember);
            levelIsOdd = !levelIsOdd;
            result.add(listMember);
        }
        return result;
    }
}
