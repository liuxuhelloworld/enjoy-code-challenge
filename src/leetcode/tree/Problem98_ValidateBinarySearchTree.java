package leetcode.tree;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class Problem98_ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return isValidBSTUsingRecur(root, null, null);
	}

	private boolean isValidBSTUsingRecur(TreeNode cur, Integer lower, Integer upper) {
		if (cur == null) {
			return true;
		}

		if (lower != null && cur.val <= lower) {
			return false;
		}

		if (upper != null && cur.val >= upper) {
			return false;
		}

		if (!isValidBSTUsingRecur(cur.left, lower, cur.val)) {
			return false;
		}

		if (!isValidBSTUsingRecur(cur.right, cur.val, upper)) {
			return false;
		}

		return true;
	}

	public boolean isValidBSTV2(TreeNode root) {
		if (root == null) {
			return true;
		}

		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		TreeNode prev = null;
		while (node != null
			|| !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}

			TreeNode cur = stack.pop();

			if (prev != null && cur.val <= prev.val) {
				return false;
			}

			prev = cur;

			if (cur.right != null) {
				node = cur.right;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Problem98_ValidateBinarySearchTree obj = new Problem98_ValidateBinarySearchTree();
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(6);


		root.left = node1;
		root.right = node2;
		node2.left = node3;
		node2.right = node4;

		System.out.println(obj.isValidBSTV2(root));
	}
}
