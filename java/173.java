package leetcode;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST. 
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * @author jun
 *
 */

public class BSTIterator {
	private Stack<TreeNode> stk;
    public BSTIterator(TreeNode root) {
    	stk = new Stack<TreeNode>();
    	while(root != null){
    		stk.push(root);
    		root = root.left;
    	}        
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stk.empty();
    }

    /** @return the next smallest number */
    public int next() {
    	TreeNode smallest = stk.pop();
        int val = smallest.val;
        if(smallest.right != null) {
        	smallest = smallest.right;
        	while(smallest != null) {
        		stk.push(smallest);
        		smallest = smallest.left;
        	}
        }
        return val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
