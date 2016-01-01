package leetcode;
/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * Populate each next pointer to point to its next right node. 
 * If there is no next right node, the next pointer should be set to NULL. 
 * Initially, all next pointers are set to NULL.
 */

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

public class Connect {
	public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        if(root.left != null) {
            root.left.next = root.right;
            if(root.next != null)
                root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }
}
