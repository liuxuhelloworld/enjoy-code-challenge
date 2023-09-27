package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 */
public class Problem113_PathSum {
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
		List<Integer> cur = new ArrayList<>();

		dfs(result, cur, root, targetSum);

		return result;
	}

	private void dfs(List<List<Integer>> result, List<Integer> cur, TreeNode node, int target) {
		if (node == null) {
			return;
		}

		if (isLeafNode(node)) {
			if (node.val == target) {
				cur.add(node.val);
				result.add(clone(cur));
				cur.remove(cur.size() - 1);
			}
			return;
		}

		if (node.left != null) {
			cur.add(node.val);
			dfs(result, cur, node.left, target - node.val);
			cur.remove(cur.size() - 1);
		}

		if (node.right != null) {
			cur.add(node.val);
			dfs(result, cur, node.right, target - node.val);
			cur.remove(cur.size() - 1);
		}
	}

	private boolean isLeafNode(TreeNode node) {
		return node != null
			&& node.left == null
			&& node.right == null;
	}

	private List<Integer> clone(List<Integer> list) {
		return list.stream()
			.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		Problem113_PathSum obj = new Problem113_PathSum();

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
