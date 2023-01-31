package leetcode.list;

/**
 * https://leetcode.cn/problems/merge-in-between-linked-lists/
 */
public class Problem1669_MergeInBetweenLinkedLists {
	private static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
		ListNode head = list2, tail = list2;
		while (tail.next != null) {
			tail = tail.next;
		}

		ListNode p = list1, q;
		int idx = 0;
		while (idx != a - 1) {
			p = p.next;
			idx++;
		}
		q = p.next;
		idx++;
		while (idx != b) {
			q = q.next;
			idx++;
		}

		p.next = head;
		tail.next = q.next;
		q.next = null;

		return list1;
	}

	public static void main(String[] args) {
		Problem1669_MergeInBetweenLinkedLists obj = new Problem1669_MergeInBetweenLinkedLists();
		ListNode list1 = new ListNode(0);
		list1.next = new ListNode(1);
		list1.next.next = new ListNode(2);
		list1.next.next.next = new ListNode(3);
		list1.next.next.next.next = new ListNode(4);
		list1.next.next.next.next.next = new ListNode(5);

		ListNode list2 = new ListNode(10000);
		list2.next = new ListNode(10001);
		list2.next.next = new ListNode(10002);

		list1 = obj.mergeInBetween(list1, 3, 4, list2);
	}
}
