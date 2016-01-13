// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
        	return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new ListsComparator());
        
        // add first node of each list into the queue;
        for(ListNode head : lists)
        	if(head != null)
        		queue.add(head);
        
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        while(!queue.isEmpty()) {
        	p.next = queue.poll();
        	p = p.next;
        	if(p.next != null)
        		queue.add(p.next);
        }
        return dummyHead.next;	
    }
    
	class ListsComparator implements Comparator<ListNode> {
		public int compare(ListNode a, ListNode b) {
    		if(a.val > b.val)		return 1;
    		else if(a.val == b.val)	return 0;
    		else					return -1;
    	} 
	}
}
