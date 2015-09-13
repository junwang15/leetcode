/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if(head == null)	return head;
    	
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode p1 = dummy, p2 = dummy;
    	for(; p1 != null && n >= 0; n--)
    		p1 = p1.next;
    	while(p1 != null) {
    		p2 = p2.next;
    		p1 = p1.next;
    	}
    	p2.next = p2.next.next;
    	return dummy.next;
    }
}
