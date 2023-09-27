package leetcode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class Problem206_ReverseLinkedList {
	private static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode reverseList(ListNode head) {
		ListNode dummy = new ListNode();

		ListNode p = head;
		while (p != null) {
			ListNode tmp = p.next;
			p.next = dummy.next;
			dummy.next = p;
			p = tmp;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		Problem206_ReverseLinkedList obj = new Problem206_ReverseLinkedList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		head = obj.reverseList(head);
		System.out.println(head);
	}
}
