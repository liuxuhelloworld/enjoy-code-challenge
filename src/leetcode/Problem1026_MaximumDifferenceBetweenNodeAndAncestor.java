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

		TreeNode maxDiffNodeMax = new TreeNode(0);
		TreeNode maxDiffNodeMin = new TreeNode(0);

		dfs(root, path, maxDiffNodeMax, maxDiffNodeMin);

		return Math.abs(maxDiffNodeMax.val - maxDiffNodeMin.val);
	}

	private void dfs(TreeNode cur, List<TreeNode> path, TreeNode maxDiffNodeMax, TreeNode maxDiffNodeMin) {
		if (cur.left == null
			&& cur.right == null) {
			TreeNode maxNode = path.get(0);
			TreeNode minNode = path.get(0);
			for (TreeNode node : path) {
				if (node.val > maxNode.val) {
					maxNode = node;
				}
				if (node.val < minNode.val) {
					minNode = node;
				}
			}

			if (Math.abs(maxNode.val - minNode.val) > Math.abs(maxDiffNodeMax.val - maxDiffNodeMin.val)) {
				maxDiffNodeMax.val = maxNode.val;
				maxDiffNodeMin.val = minNode.val;
			}

			return;
		}

		if (cur.left != null) {
			path.add(cur.left);
			dfs(cur.left, path, maxDiffNodeMax, maxDiffNodeMin);
			path.remove(path.size() - 1);
		}
		if (cur.right != null) {
			path.add(cur.right);
			dfs(cur.right, path, maxDiffNodeMax, maxDiffNodeMin);
			path.remove(path.size() - 1);
		}
	}

	public int maxAncestorDiff2(TreeNode root) {
		Set<TreeNode> done = new HashSet<>();

		Stack<TreeNode> path = new Stack<>();
		path.add(root);

		int maxDiff = 0;
		while (!path.isEmpty()) {
			TreeNode cur = path.peek();
			if (cur.left == null
				&& cur.right == null) {

				int pathMaxDiff = maxDiff(path);
				if (pathMaxDiff > maxDiff) {
					maxDiff = pathMaxDiff;
				}

				done.add(cur);
				path.pop();

				continue;
			}

			if (cur.left != null
				&& !done.contains(cur.left)) {
				path.push(cur.left);
				continue;
			}

			if (cur.right != null
				&& !done.contains(cur.right)) {
				path.push(cur.right);
				continue;
			}

			done.add(cur);
			path.pop();
		}

		return maxDiff;
	}

	private int maxDiff(Stack<TreeNode> path) {
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

	public static void main(String[] args) {
		Problem1026_MaximumDifferenceBetweenNodeAndAncestor obj =
			new Problem1026_MaximumDifferenceBetweenNodeAndAncestor();

		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(0);
		root.right.right.left = new TreeNode(3);

		System.out.println(obj.maxAncestorDiff2(root));
	}
}
