package leetcode.twopointers;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class Problem876_MiddleOfLinkedList {
	public ListNode middleNode(ListNode head) {
		ListNode cur = head, mid = head;
		int curIndex = 0;

		while (cur != null) {
			if (curIndex % 2 == 1) {
				mid = mid.next;
			}

			cur = cur.next;
			curIndex++;
		}

		return mid;
	}

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		Problem876_MiddleOfLinkedList obj = new Problem876_MiddleOfLinkedList();
		ListNode list = new ListNode(1);
		list.next = new ListNode(2);
		list.next.next = new ListNode(3);
		list.next.next.next = new ListNode(4);
		obj.middleNode(list);
	}
}