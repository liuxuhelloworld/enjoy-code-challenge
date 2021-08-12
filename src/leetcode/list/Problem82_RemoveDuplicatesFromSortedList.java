package leetcode.list;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class Problem82_RemoveDuplicatesFromSortedList {
	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(-1);
		ListNode slow, fast;

		slow = dummy;
		fast = head;
		while (fast != null) {
			int target = fast.val;
			int cnt = 1;

			while (fast.next != null) {
				if (fast.next.val == target) {
					fast = fast.next;
					cnt++;
				} else {
					break;
				}
			}

			if (cnt == 1) {
				slow.next = fast;
				slow = slow.next;
			} else {
				slow.next = null;
			}

			fast = fast.next;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		Problem82_RemoveDuplicatesFromSortedList obj = new Problem82_RemoveDuplicatesFromSortedList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next = new ListNode(5);

		head = obj.deleteDuplicates(head);

		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);

		head = obj.deleteDuplicates(head);
	}
}
