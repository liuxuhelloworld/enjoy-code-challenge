package leetcode;

public class Problem61_RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return null;
		}

		ListNode[] prevArr = new ListNode[500];

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode prev = dummy;
		ListNode tail;
		int i = 0;
		int len = 0;
		for (ListNode p = dummy.next; p != null; p = p.next) {
			prevArr[i++] = prev;
			prev = p;
			len++;
		}

		k = k % len;

		if (k == 0) {
			return head;
		}

		prev = prevArr[len - k];
		tail = prevArr[len - 1].next;
		ListNode newHead = prev.next;
		prev.next = null;
		tail.next = head;

		return newHead;
	}

	public static void main(String[] args) {
		Problem61_RotateList obj = new Problem61_RotateList();
		ListNode head = new ListNode(1);

		head = obj.rotateRight(head, 1);
		ListNode.print(head);

		head = obj.rotateRight(head, 2);
		ListNode.print(head);
	}
}
