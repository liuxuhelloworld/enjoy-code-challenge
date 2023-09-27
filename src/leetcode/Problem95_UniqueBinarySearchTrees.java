package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 */
public class Problem95_UniqueBinarySearchTrees {
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

	public List<TreeNode> generateTrees(int n) {
		assert n >= 1 && n <= 8;

		List<TreeNode> ret = new ArrayList<>();
		ret.add(new TreeNode(1));

		for (int i = 2; i <= n; i++) {
			List<TreeNode> newRet = new ArrayList<>();

			for (TreeNode node : ret) {
				newRet.addAll(addNewNode(node, i));
			}

			ret = newRet;
		}

		return ret;
	}

	private List<TreeNode> addNewNode(TreeNode node, int val) {
		List<TreeNode> ret = new ArrayList<>();

		int depth = getDepthOfRightestNode(node);

		for (int i = 0; i <= depth; i++) {
			TreeNode copy = copy(node);
			TreeNode prev = null, cur = copy;

			int j = 0;
			while (j++ < i) {
				prev = cur;
				cur = cur.right;
			}

			TreeNode newVal = new TreeNode(val);
			newVal.left = cur;
			if (prev == null) {
				ret.add(newVal);
			} else {
				prev.right = newVal;
				ret.add(copy);
			}
		}

		return ret;
	}

	private int getDepthOfRightestNode(TreeNode node) {
		int depth = 0;
		while (node != null) {
			depth++;
			node = node.right;
		}

		return depth;
	}

	private TreeNode copy(TreeNode node) {
		if (node == null) {
			return null;
		}

		TreeNode copy = new TreeNode(node.val);
		copy.left = copy(node.left);
		copy.right = copy(node.right);

		return copy;
	}

	public static void main(String[] args) {
		Problem95_UniqueBinarySearchTrees obj = new Problem95_UniqueBinarySearchTrees();
		List<TreeNode> binarySearchTrees = obj.generateTrees(1);
		System.out.println(binarySearchTrees);

		binarySearchTrees = obj.generateTrees(2);
		System.out.println(binarySearchTrees);

		binarySearchTrees = obj.generateTrees(3);
		System.out.println(binarySearchTrees);

		binarySearchTrees = obj.generateTrees(4);
		System.out.println(binarySearchTrees);
	}
}
