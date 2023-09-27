package leetcode;

/**
 * https://leetcode-cn.com/problems/partition-list/
 */
public class Problem0086_PartitionList {
	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode partition(ListNode head, int x) {
		if (head == null) {
			return null;
		}

		ListNode leftDummy = new ListNode(-1);
		ListNode rightDummy = new ListNode(-1);
		ListNode leftTail = leftDummy;
		ListNode rightTail = rightDummy;

		ListNode p = head;
		while (p != null) {
			if (p.val < x) {
				leftTail.next = p;
				leftTail = leftTail.next;
			} else {
				rightTail.next = p;
				rightTail = rightTail.next;
			}

			p = p.next;
		}

		rightTail.next = null;
		leftTail.next = rightDummy.next;

		return leftDummy.next;
	}

	public static void main(String[] args) {
		Problem0086_PartitionList obj = new Problem0086_PartitionList();

		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);
		head = obj.partition(head, 3);

		head = new ListNode(2);
		head = obj.partition(head, 3);
	}
}
