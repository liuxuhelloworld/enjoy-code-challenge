package leetcode;

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
		TreeNode[] parents = new TreeNode[1001]; // parent[i] represents the value i node's parent
		TreeNode[] self = new TreeNode[1001]; // self[i] represents the value i node self

		preOrder(root, parents, self);

		for (int i = 0; i < to_delete.length; i++) {
			int toDeleteVal = to_delete[i];

			for (int j = 0; j < parents.length; j++) {
				if (parents[j] != null
					&& parents[j].val == toDeleteVal) {
					parents[j] = null;
				}
			}

			TreeNode parent = parents[toDeleteVal];
			if (parent != null) {
				boolean isLeftChild = parent.left != null && parent.left.val == toDeleteVal;
				if (isLeftChild) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}

			self[toDeleteVal] = null;
		}

		List<TreeNode> forest = new ArrayList<>();
		for (int i = 1; i < parents.length; i++) {
			TreeNode parent = parents[i];
			if (parent == null
				&& self[i] != null) {
				forest.add(self[i]);
			}
		}

		return forest;
	}

	private void preOrder(TreeNode node, TreeNode[] parents, TreeNode[] self) {
		if (node == null) {
			return;
		}

		self[node.val] = node;

		if (node.left != null) {
			TreeNode left = node.left;
			parents[left.val] = node;
			preOrder(left, parents, self);
		}

		if (node.right != null) {
			TreeNode right = node.right;
			parents[right.val] = node;
			preOrder(right, parents, self);
		}
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
