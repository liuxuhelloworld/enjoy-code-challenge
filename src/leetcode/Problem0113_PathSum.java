package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 */
public class Problem0113_PathSum {
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

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> result = new ArrayList<>();
		List<TreeNode> path = new ArrayList<>();

		dfs(result, path, root, targetSum);

		return result;
	}

	private void dfs(List<List<Integer>> result, List<TreeNode> path, TreeNode node, int target) {
		if (node == null) {
			return;
		}

		path.add(node);

		if (node.left == null
			&& node.right == null) {
			if (node.val == target) {
				result.add(path.stream().map(e -> e.val).toList());
			}
		}

		if (node.left != null) {
			dfs(result, path, node.left, target - node.val);
		}

		if (node.right != null) {
			dfs(result, path, node.right, target - node.val);
		}

		path.remove(path.size() - 1);
	}

	public static void main(String[] args) {
		Problem0113_PathSum obj = new Problem0113_PathSum();

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		System.out.println(obj.pathSum(root, 22));

		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(obj.pathSum(root, 5));

		root = new TreeNode(1);
		root.left = new TreeNode(2);
		System.out.println(obj.pathSum(root, 0));
	}
}
