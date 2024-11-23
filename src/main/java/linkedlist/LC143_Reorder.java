package linkedlist;

public class LC143_Reorder {

    public static void main(String[] args) {
        ListNode $1 = new ListNode(1);
        ListNode $2 = new ListNode(2);
        ListNode $3 = new ListNode(3);
        ListNode $4 = new ListNode(4);

        $1.next = $2;
        $2.next = $3;
        $3.next = $4;
        LC143_Reorder problem = new LC143_Reorder();
        problem.reorderList($1);
    }

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        // Find the mid-point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null; // break to avoid cycle

        // Reverse the second list
        ListNode prev = null;
        ListNode curr = second;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        second = prev; // new head of the second half

        ListNode first = head;

        while (second != null) {
            ListNode secondNext = second.next;
            ListNode firstNext = first.next;
            first.next = second;
            second.next = firstNext;
            first = firstNext;
            second = secondNext;
        }



    }

}
