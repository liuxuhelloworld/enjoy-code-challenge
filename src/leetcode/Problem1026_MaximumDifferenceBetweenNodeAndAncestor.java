package leetcode;

import java.util.*;

/**
 * https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor/
 */
public class Problem1026_MaximumDifferenceBetweenNodeAndAncestor {
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

	public int maxAncestorDiff(TreeNode root) {
		List<TreeNode> path = new ArrayList<>();
		path.add(root);

		return dfs(root, path, 0);
	}

	private int dfs(TreeNode cur, List<TreeNode> path, int maxDiff) {
		if (cur.left == null
			&& cur.right == null) {
			int pathMaxDiff = pathMaxDiff(path);
            return Math.max(pathMaxDiff, maxDiff);
		}

		if (cur.left != null) {
			path.add(cur.left);
			maxDiff = dfs(cur.left, path, maxDiff);
			path.remove(path.size() - 1);
		}
		if (cur.right != null) {
			path.add(cur.right);
			maxDiff = dfs(cur.right, path, maxDiff);
			path.remove(path.size() - 1);
		}

		return maxDiff;
	}

	private int pathMaxDiff(List<TreeNode> path) {
		int max = path.get(0).val, min = path.get(0).val;
		for (TreeNode node : path) {
			if (node.val > max) {
				max = node.val;
			}
			if (node.val < min) {
				min = node.val;
			}
		}

		return max - min;
	}

	public int maxAncestorDiff2(TreeNode root) {
		return dfs(root, root.val, root.val, 0);
	}

	private int dfs(TreeNode cur, int max, int min, int maxDiff) {
		if (cur == null) {
			return maxDiff;
		}

		max = Math.max(cur.val, max);
		min = Math.min(cur.val, min);
		maxDiff = Math.max(maxDiff, max - min);

		if (cur.left == null
			&& cur.right == null) {
			return maxDiff;
		}

		if (cur.left != null) {
			maxDiff = dfs(cur.left, max, min, maxDiff);
		}
		if (cur.right != null) {
			maxDiff = dfs(cur.right, max, min, maxDiff);
		}

		return maxDiff;
	}

	public static void main(String[] args) {
		Problem1026_MaximumDifferenceBetweenNodeAndAncestor obj =
			new Problem1026_MaximumDifferenceBetweenNodeAndAncestor();

		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(3);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(6);
		root.right.right = new TreeNode(14);
		root.left.right.left = new TreeNode(4);
		root.left.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(13);

		System.out.println(obj.maxAncestorDiff(root));
	}
}
