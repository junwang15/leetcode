package leetcode;

public class SortMethods {
	public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)	return head;
        // count the length of the linked list
        int len = 0;
        for(ListNode tmp = head; tmp != null; tmp = tmp.next)
        	len++;
        if(len == 2) {
        	if(head.val > head.next.val) {
        		int tmp = head.val;
        		head.val = head.next.val;
        		head.next.val = tmp;
        	}
        	return head;
        }
        // break the list into two sublists
        ListNode left = head, right = head, tmp = head;
        for(int i = 0; i < len/2 - 1; i++)
        	tmp = tmp.next;
        right = tmp.next;
        tmp.next = null;
        left = sortList(left);
        right = sortList(right);
        head = merge(left, right);
        return head;
    }
	
	private ListNode merge(ListNode n1, ListNode n2) {
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while(n1 != null && n2 != null) {
			if(n1.val < n2.val) {
				p.next = n1;
				n1 = n1.next;
				p = p.next;
			} else {
				p.next = n2;
				n2 = n2.next;
				p = p.next;
			}
		}
		if(n1 == null) p.next = n2;
		else if(n2 == null) p.next = n1;
		return dummy.next;
	}
    
	public static void main(String[] args) {
		ListNode n1 = new ListNode(9);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(5);
 
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(5);
 
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		
		SortMethods sm = new SortMethods();
		n1 = sm.sortList(n1);
		printList(n1);
	}
 
	public static void printList(ListNode x) {
		if(x != null){
			System.out.print(x.val + " ");
			while (x.next != null) {
				System.out.print(x.next.val + " ");
				x = x.next;
			}
			System.out.println();
		}
	}
}
