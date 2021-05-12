package leetcode.list;

import leetcode.list.ListNode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class Problem2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), tail = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            int val = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;
            tail.next = new ListNode(val);
            tail = tail.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry == 1) {
            tail.next = new ListNode(1);
        }

        return dummy.next;
    }
}