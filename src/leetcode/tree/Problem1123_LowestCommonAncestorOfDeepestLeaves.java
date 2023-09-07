package leetcode.tree;

import java.util.*;

/**
 * https://leetcode.cn/problems/lowest-common-ancestor-of-deepest-leaves/
 */
public class Problem1123_LowestCommonAncestorOfDeepestLeaves {
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

	public TreeNode lcaDeepestLeaves(TreeNode root) {
		if (root == null) {
			return null;
		}

		Map<TreeNode, TreeNode> parents = new HashMap<>();
		parents.put(root, null);

		List<TreeNode> list = new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			list.clear();

			int size = queue.size();
			while (size-- > 0) {
				TreeNode node = queue.poll();

				list.add(node);

				if (node.left != null) {
					queue.offer(node.left);
					parents.put(node.left, node);
				}
				if (node.right != null) {
					queue.offer(node.right);
					parents.put(node.right, node);
				}
			}
		}

		if (list.size() == 1) {
			return list.get(0);
		}

		while (true) {
			if (allSame(list)) {
				return list.get(0);
			}

			list.replaceAll(parents::get);
		}
	}

	private boolean allSame(List<TreeNode> list) {
		TreeNode first = list.get(0);
		for (TreeNode node : list) {
			if (node != first) {
				return false;
			}
		}

		return true;
	}

	public TreeNode lcaDeepestLeaves2(TreeNode root) {
		Object[] ret = recur(root);
		return (TreeNode) ret[1];
	}

	private Object[] recur(TreeNode node) {
		if (node == null) {
			return new Object[] {0, null};
		}

		Object[] left = recur(node.left);
		Object[] right = recur(node.right);

		int leftDepth = (int) left[0];
		TreeNode leftLca = (TreeNode) left[1];
		int rightDepth = (int) right[0];
		TreeNode rightLca = (TreeNode) right[1];
		if (leftDepth > rightDepth) {
			return new Object[] {leftDepth + 1, leftLca};
		} else if (leftDepth < rightDepth) {
			return new Object[] {rightDepth + 1, rightLca};
		} else {
			return new Object[] {leftDepth + 1, node};
		}
	}

	public static void main(String[] args) {
		Problem1123_LowestCommonAncestorOfDeepestLeaves obj = new Problem1123_LowestCommonAncestorOfDeepestLeaves();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(8);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);

		TreeNode ret = obj.lcaDeepestLeaves2(root);
	}
}
