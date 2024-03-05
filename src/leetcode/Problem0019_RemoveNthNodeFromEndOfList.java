package leetcode;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class Problem0019_RemoveNthNodeFromEndOfList {
	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode p = dummy, q = dummy;
		for (int i = 0; i <= n; i++) {
			p = p.next;
		}

		while (p != null) {
			p = p.next;
			q = q.next;
		}
		q.next = q.next.next;

		return dummy.next;
	}

	public static void main(String[] args) {
		Problem0019_RemoveNthNodeFromEndOfList obj = new Problem0019_RemoveNthNodeFromEndOfList();
		ListNode head = new ListNode(1);

		head = obj.removeNthFromEnd(head, 1);
	}
}
