package leetcode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class Problem0092_ReverseLinkedList {
	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode reverseBetween(ListNode head, int left, int right) {
		assert head != null;
		assert left >= 1 && right >= 1 && left <= right;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode p = dummy;
		for (int i = 1; i < left; i++) {
			p = p.next;
		}

		ListNode prevLeft = p;
		ListNode reversedTail = p.next;

		ListNode reversedDummy = new ListNode(-1);
		ListNode cur = p.next;
		ListNode next = null;
		for (int i = 0; i < right-left+1; i++) {
			next = cur.next;
			cur.next = reversedDummy.next;
			reversedDummy.next = cur;
			cur = next;
		}

		prevLeft.next = reversedDummy.next;
		reversedTail.next = next;

		return dummy.next;
	}

	public static void main(String[] args) {
		Problem0092_ReverseLinkedList obj = new Problem0092_ReverseLinkedList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		head = obj.reverseBetween(head, 2, 4);

		head = new ListNode(5);
		head = obj.reverseBetween(head, 1,1);
	}
}
