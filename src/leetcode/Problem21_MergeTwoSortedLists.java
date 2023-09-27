package leetcode;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class Problem21_MergeTwoSortedLists {
	private static class ListNode {
		int val;
		ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}

		ListNode dummy = new ListNode();
		ListNode last = dummy;

		ListNode p = l1, q = l2;
		while (p != null && q != null) {
			if (p.val <= q.val) {
				last.next = p;
				p = p.next;
			} else {
				last.next = q;
				q = q.next;
			}
			last = last.next;
		}

		if (p != null) {
			last.next = p;
		}

		if (q != null) {
			last.next = q;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		Problem21_MergeTwoSortedLists obj = new Problem21_MergeTwoSortedLists();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);

		l1 = obj.mergeTwoLists(l1, l2);
		System.out.println(l1);

		l1 = obj.mergeTwoLists(null, null);
		System.out.println(l1);

		l1 = null;
		l2 = new ListNode(0);
		l1 = obj.mergeTwoLists(l1, l2);
		System.out.println(l1);
	}
}
