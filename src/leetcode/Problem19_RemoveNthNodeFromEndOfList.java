package leetcode;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class Problem19_RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n <= 0) {
			return head;
		}

		int size = size(head);
		if (size == n) {
			head = head.next;
		} else if (size > n) {
			ListNode p = head;
			int i = 1;
			while (i++ < size-n) {
				p = p.next;
			}
			p.next = p.next.next;
		}

		return head;
	}

	private int size(ListNode node) {
		int size = 0;
		while (node != null) {
			size++;
			node = node.next;
		}

		return size;
	}

	public ListNode removeNthFromEndV2(ListNode head, int n) {
		if (head == null || n <= 0) {
			return head;
		}

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode p = dummy, q = dummy;
		for (int i = 0; i < n+1; i++) {
			if (p != null) {
				p = p.next;
			} else {
				return head;
			}
		}

		while (p != null) {
			p = p.next;
			q = q.next;
		}
		q.next = q.next.next;

		return dummy.next;
	}
}
