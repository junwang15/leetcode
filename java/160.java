/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * @author jun
 *
 */
public class GetIntersectionNode {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA = getLength(headA);
		int lenB = getLength(headB);
		int diff = Math.abs(lenA - lenB);
		if(lenA > lenB)
			while(diff-- > 0)	headA = headA.next;
		else
			while(diff-- > 0)	headB = headB.next;
		while(headA != null && headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
    }
	
	private int getLength(ListNode head) {
        int cnt = 0;
        ListNode tmp = head;
        while(tmp != null) {
        	cnt++;
        	tmp = tmp.next;
        }
        return cnt;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n3;
		n2.next = n3;
		n3.next = n4;
		GetIntersectionNode gin = new GetIntersectionNode();
		System.out.println(gin.getIntersectionNode(n1, n2).val);
	}

}
