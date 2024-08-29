package leetcode;

import java.util.Arrays;
import java.util.List;

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
		List<Object> ret = recur(root);
		return (TreeNode) ret.get(1);
	}

	private List<Object> recur(TreeNode node) {
		if (node == null) {
			return Arrays.asList(0, null);
		}

		List<Object> left = recur(node.left);
		List<Object> right = recur(node.right);

		int leftDepth = (int) left.get(0);
		TreeNode leftLca = (TreeNode) left.get(1);
		int rightDepth = (int) right.get(0);
		TreeNode rightLca = (TreeNode) right.get(1);
		if (leftDepth > rightDepth) {
			return Arrays.asList(leftDepth + 1, leftLca);
		} else if (leftDepth < rightDepth) {
			return Arrays.asList(rightDepth + 1, rightLca);
		} else {
			return Arrays.asList(leftDepth + 1, node);
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

		TreeNode ret = obj.lcaDeepestLeaves(root);
	}
}
