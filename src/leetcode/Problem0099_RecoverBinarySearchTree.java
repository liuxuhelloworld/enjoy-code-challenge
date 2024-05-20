package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 */
public class Problem0099_RecoverBinarySearchTree {
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
		for (int i = 0; i < inOrderList.size() - 1; i++) {
			TreeNode cur = inOrderList.get(i);
			TreeNode next = inOrderList.get(i+1);
			if (cur.val > next.val) {
				swappedLarge = cur;
				break;
			}
		}
		for (int i = inOrderList.size() - 1; i > 0; i--) {
			TreeNode cur = inOrderList.get(i);
			TreeNode prev = inOrderList.get(i-1);
			if (cur.val < prev.val) {
				swappedSmall = cur;
				break;
			}
		}

		assert swappedLarge != null;
		assert swappedSmall != null;

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

	public static void main(String[] args) {
		Problem0099_RecoverBinarySearchTree obj = new Problem0099_RecoverBinarySearchTree();

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(2);

		obj.recoverTree(root);

		System.out.println(root);
	}
}
