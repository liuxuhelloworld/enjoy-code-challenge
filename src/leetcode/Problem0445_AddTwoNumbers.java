package leetcode;

/**
 * https://leetcode.cn/problems/add-two-numbers-ii/
 */
public class Problem0445_AddTwoNumbers {
	private int carry = 0;

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int size1 = size(l1);
		int size2 = size(l2);

		ListNode ret = recur(l1, size1, l2, size2);
		if (carry != 0) {
			ListNode head = new ListNode(1);
			head.next = ret;
			return head;
		}

		return ret;
	}

	private int size(ListNode list) {
		int size = 0;
		while (list != null) {
			size++;
			list = list.next;
		}

		return size;
	}

	private ListNode recur(ListNode l1, int size1, ListNode l2, int size2) {
		if (size1 == 0) {
			return l2;
		}
		if (size2 == 0) {
			return l1;
		}

		ListNode next;

		int val1 = 0, val2 = 0;
		if (size1 == size2) {
			val1 = l1.val;
			val2 = l2.val;
			next = recur(l1.next, size1 - 1, l2.next, size2 - 1);
		} else if (size1 < size2) {
			val2 = l2.val;
			next = recur(l1, size1, l2.next, size2 - 1);
		} else {
			val1 = l1.val;
			next = recur(l1.next, size1 - 1, l2, size2);
		}

		int remain = (val1 + val2 + carry) % 10;
		carry = (val1 + val2 + carry) / 10;

		ListNode current = new ListNode(remain);
		current.next = next;

		return current;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		Problem0445_AddTwoNumbers obj = new Problem0445_AddTwoNumbers();
		ListNode l3 = obj.addTwoNumbers(l1, l2);
		System.out.println(l3);
	}
}
