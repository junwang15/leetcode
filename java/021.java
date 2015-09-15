/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // the first three lines can speed up the algorithm
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(l1 != null && l2 != null) {
        	if(l1.val < l2.val) {
        		current.next = l1;
        		l1 = l1.next;
        	} else {
        		current.next = l2;
        		l2 = l2.next;
        	}
        	current = current.next;
        }
        if(l1 != null)      current.next = l1;
        else if(l2 != null) current.next = l2;
        return dummy.next;        
    }
}

// solution 2: recursive solution
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        dummy.next = helper(l1, l2);
        return dummy.next;      
    }
    
    private ListNode helper(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        if(l1.val < l2.val) {
            l1.next = helper(l1.next, l2);
            return l1;
        } else {
            l2.next = helper(l1, l2.next);
            return l2;
        }
    }
}
