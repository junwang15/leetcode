package leetcode;

public class SortMethods {
	public ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode dummyNew = new ListNode(Integer.MIN_VALUE);
        while(dummy.next != null) {
        	insertToList(dummyNew, dummy.next.val);
        	dummy.next = dummy.next.next;
        }
        return dummyNew.next;
    }
	
	void insertToList(ListNode dummyHead, int val) {
		ListNode lastp = dummyHead, p = dummyHead.next;
		while(p != null && p.val <= val){
			p = p.next;
			lastp = lastp.next;
		}
		insertAfterNode(lastp, val);
	}
	
	void insertAfterNode(ListNode oldNode, int val) {
		if(oldNode == null)	return;
		ListNode newNode = new ListNode(val);
		ListNode nextNode = oldNode.next;
		oldNode.next = newNode;
		newNode.next = nextNode;
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
		printList(n1);
		n1 = sm.insertionSortList(n1);
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
