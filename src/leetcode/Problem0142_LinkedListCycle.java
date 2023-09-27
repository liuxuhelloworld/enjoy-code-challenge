package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class Problem0142_LinkedListCycle {
	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode detectCycle(ListNode head) {
		Set<ListNode> visited = new HashSet<>();

		for (ListNode p = head; p != null; p = p.next) {
			if (visited.contains(p)) {
				return p;
			}

			visited.add(p);
		}

		return null;
	}

	public static void main(String[] args) {
		Problem0142_LinkedListCycle obj = new Problem0142_LinkedListCycle();

		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(-4);
		head.next.next.next.next = head.next;
		ListNode cycle = obj.detectCycle(head);

		head = new ListNode(1);
		head.next = head;
		cycle = obj.detectCycle(head);
	}
}
