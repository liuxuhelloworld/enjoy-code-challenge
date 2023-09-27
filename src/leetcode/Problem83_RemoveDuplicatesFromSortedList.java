package leetcode;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class Problem83_RemoveDuplicatesFromSortedList {
	private static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode last = head;
		for (ListNode cur = head.next; cur != null; cur = cur.next) {
			if (cur.val != last.val) {
				last.next = cur;
				last = cur;
			}
		}
		last.next = null;

		return head;
	}

	public static void main(String[] args) {
		Problem83_RemoveDuplicatesFromSortedList obj = new Problem83_RemoveDuplicatesFromSortedList();

		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(3);
		head = obj.deleteDuplicates(head);
	}
}
