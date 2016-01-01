package leetcode;
/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * Follow up for problem "Populating Next Right Pointers in Each Node". 
 * What if the given tree could be any binary tree? Would your previous solution still work?
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
        if(root.left != null)
        	root.left.next = root.right != null ? root.right : getNext(root);
        if(root.right != null)
        	root.right.next = getNext(root);
        
        connect(root.right);
        connect(root.left);
    }
	
	private TreeLinkNode getNext(TreeLinkNode node) {
		TreeLinkNode tmp = node.next;
		while(tmp != null) {
			if(tmp.left != null)	return tmp.left;
			if(tmp.right != null)	return tmp.right;
			tmp = tmp.next;
		}
		return null;
	}
}
