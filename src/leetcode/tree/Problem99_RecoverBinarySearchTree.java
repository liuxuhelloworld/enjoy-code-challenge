package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 */
public class Problem99_RecoverBinarySearchTree {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode() {
		}

		public TreeNode(int val) {
			this.val = val;
		}

		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public void recoverTree(TreeNode root) {
		List<TreeNode> inOrderList = new ArrayList<>();

		inOrderTraverse(root, inOrderList);

		TreeNode swappedLarge = null, swappedSmall = null;
		TreeNode prev = null;
		for (TreeNode cur : inOrderList) {
			if (prev != null && prev.val > cur.val) {
				swappedSmall = cur;
				if (swappedLarge == null) {
					swappedLarge = prev;
				}
			}
			prev = cur;
		}

		int tmp = swappedLarge.val;
		swappedLarge.val = swappedSmall.val;
		swappedSmall.val = tmp;
	}

	private void inOrderTraverse(TreeNode node, List<TreeNode> inOrderList) {
		if (node == null) {
			return;
		}

		inOrderTraverse(node.left, inOrderList);
		inOrderList.add(node);
		inOrderTraverse(node.right, inOrderList);
	}

	public void recoverTreeV2(TreeNode root) {
		assert root != null;

		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		TreeNode prev = null;
		TreeNode swappedLarge = null, swappedSmall = null;
		while (node != null
			|| !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}

			TreeNode cur = stack.pop();
			if (prev != null && prev.val > cur.val) {
				swappedSmall = cur;
				if (swappedLarge == null) {
					swappedLarge = prev;
				}
			}
			prev = cur;

			if (cur.right != null) {
				node = cur.right;
			}
		}

		int tmp = swappedLarge.val;
		swappedLarge.val = swappedSmall.val;
		swappedSmall.val = tmp;
	}

	public static void main(String[] args) {
		Problem99_RecoverBinarySearchTree obj = new Problem99_RecoverBinarySearchTree();

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(2);

		obj.recoverTreeV2(root);

		System.out.println(root);
	}
}
