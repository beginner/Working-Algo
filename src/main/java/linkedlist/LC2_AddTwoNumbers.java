package linkedlist;

// https://leetcode.com/problems/add-two-numbers
public class LC2_AddTwoNumbers {

    // TC -> O (max (m, n))
    // SC -> O(1)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode newNode = dummy;

        while (l1 != null || l2 != null || carry != 0) {
            int total = l1 == null ? 0 : l1.val;
            total += l2 == null ? 0 : l2.val;
            total += carry;
            newNode.next = new ListNode(total % 10);
            carry = total / 10;
            newNode = newNode.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }
        return dummy.next;
    }

}
