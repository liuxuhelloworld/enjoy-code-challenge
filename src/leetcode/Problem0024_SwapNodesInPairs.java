package leetcode;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class Problem0024_SwapNodesInPairs {
	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode swappedTail = dummy;

		while (swappedTail.next != null) {
			ListNode p, q;

			p = swappedTail.next;
			if (p.next == null) {
				break;
			} else {
				q = p.next;
			}

			p.next = q.next;
			q.next = p;
			swappedTail.next = q;
			swappedTail = p;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		Problem0024_SwapNodesInPairs obj = new Problem0024_SwapNodesInPairs();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		head = obj.swapPairs(head);

		System.out.println(head);
	}
}
