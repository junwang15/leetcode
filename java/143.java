import java.util.List;

/**
 * Created by jun on 1/22/16.
 */
public class MyList {
    public static ListNode covert2LinkedList(int[] nums) {
        if(nums == null)    return null;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for(int i = 0; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        while(head != null) {
            System.out.print("" + head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
     reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
     You must do this in-place without altering the nodes' values.
     For example,
     Given {1,2,3,4}, reorder it to {1,4,2,3}.
     * @param head
     */
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return;

        // find the middle of the linked list
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode second = slow.next;
        slow.next = null;       // Remember to close the first half

        // reverse the second half of the linked list
        ListNode p2 = reverseList(second);
        ListNode p1 = head;
        // merge the two lists
        while(p2 != null) {
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;
            p1.next = p2;
            p2.next = temp1;
            p1 = temp1;
            p2 = temp2;
        }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode prev = head, curr = head.next;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head.next = null;
        return prev;
    }

    public static void main(String[] args) {
        MyList list = new MyList();
        int[] input = {1,2,3,4,5};
        ListNode head = covert2LinkedList(input);
        printList(head);
        list.reorderList(head);
        printList(head);
    }
}
