package leetcode;

import java.util.Stack;

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
		Stack<Integer> stack1 = new Stack<>();
		while (l1 != null) {
			stack1.push(l1.val);
			l1 = l1.next;
		}

		Stack<Integer> stack2 = new Stack<>();
		while (l2 != null) {
			stack2.push(l2.val);
			l2 = l2.next;
		}

		int carry = 0;
		ListNode dummy = new ListNode(-1);

		while (!stack1.isEmpty()
			|| !stack2.isEmpty()) {

			int val1 = 0, val2 = 0;
			if (!stack1.isEmpty()) {
				val1 = stack1.pop();
			}
			if (!stack2.isEmpty()) {
				val2 = stack2.pop();
			}

			int remain = (val1 + val2 + carry) % 10;
			carry = (val1 + val2 + carry) / 10;

			ListNode node = new ListNode(remain);
			node.next = dummy.next;
			dummy.next = node;
		}

		if (carry != 0) {
			ListNode node = new ListNode(1);
			node.next = dummy.next;
			dummy.next = node;
		}

		return dummy.next;
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
