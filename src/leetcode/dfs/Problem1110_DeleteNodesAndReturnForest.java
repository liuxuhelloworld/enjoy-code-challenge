package leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/delete-nodes-and-return-forest/
 */
public class Problem1110_DeleteNodesAndReturnForest {
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

	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<Integer> toDelete = new ArrayList<>();
		Arrays.stream(to_delete).forEach(toDelete::add);

		List<TreeNode> forest = new ArrayList<>();

		dfs(root, true, toDelete, forest);

		return forest;
	}

	private TreeNode dfs(TreeNode node, boolean isRoot, List<Integer> toDelete, List<TreeNode> forest) {
		if (node == null) {
			return null;
		}

		boolean deleted = toDelete.contains(node.val);

		node.left = dfs(node.left, deleted, toDelete, forest);
		node.right = dfs(node.right, deleted, toDelete, forest);

		if (deleted) {
			return null;
		}

		if (isRoot) {
			forest.add(node);
		}

		return node;
	}

	public static void main(String[] args) {
		Problem1110_DeleteNodesAndReturnForest obj = new Problem1110_DeleteNodesAndReturnForest();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(3);

		List<TreeNode> forest = obj.delNodes(root, new int[] {2, 3});
		System.out.println(forest);
	}
}
