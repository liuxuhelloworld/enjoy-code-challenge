package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 */
public class Problem0116_PopulatingNextRightPointersInEachNode {
	private static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {}

		public Node(int val) {
			this.val = val;
		}

		public Node(int val, Node left, Node right, Node next) {
			this.val = val;
			this.left = left;
			this.right = right;
			this.next = next;
		}
	}

	public Node connect(Node root) {
		if (root == null) {
			return null;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();

			Node dummy = new Node(0);
			Node last = dummy;
			for (int i = 0; i < size; i++) {
				Node cur = queue.poll();
				last.next = cur;
				last = cur;

				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
		}

		return root;
	}

	public static void main(String[] args) {
		Problem0116_PopulatingNextRightPointersInEachNode obj = new Problem0116_PopulatingNextRightPointersInEachNode();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		root = obj.connect(root);
		System.out.println(root);
	}
}
