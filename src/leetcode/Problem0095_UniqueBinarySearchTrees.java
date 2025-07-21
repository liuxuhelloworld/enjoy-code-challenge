package leetcode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 */
public class Problem0095_UniqueBinarySearchTrees {
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

	public List<TreeNode> generateTrees1(int n) {
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

	public List<TreeNode> generateTrees2(int n) {
		assert n >= 1 && n <= 8;

		return generateTrees(1, n);
	}

	private List<TreeNode> generateTrees(int x, int y) {
		if (x > y) {
			List<TreeNode> trees = new ArrayList<>();
			trees.add(null);
			return trees;
		}

		List<TreeNode> trees = new ArrayList<>();
		for (int i = x; i <= y; i++) {
			List<TreeNode> leftTrees = generateTrees(x, i-1);
			List<TreeNode> rightTrees = generateTrees(i+1, y);

			for (TreeNode left : leftTrees) {
				for (TreeNode right : rightTrees) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					trees.add(root);
				}
			}
		}

		return trees;
	}

	public List<TreeNode> generateTrees3(int n) {
		assert n >= 1 && n <= 8;

		List[][] dp = new List[n+1][n+1]; // dp[i..j] represents the BSTs for i..j
		for (int i = 1; i <= n; i++) {
			dp[i][i] = Arrays.asList(new TreeNode(i));
		}

		for (int step = 1; step <= n-1; step++) {
			for (int i = 1; i <= n - step; i++) {
				List<TreeNode> trees = new ArrayList<>();

				for (int k = i; k <= i+step; k++) {
					TreeNode root = new TreeNode(k);

					List leftTrees = new ArrayList();
					leftTrees.add(null);
					if (k-1 >= i) {
						leftTrees = dp[i][k-1];
					}

					List rightTrees = new ArrayList();
					rightTrees.add(null);
					if (k+1 <= i+step) {
						rightTrees = dp[k+1][i+step];
					}

					for (Object left : leftTrees) {
						for (Object right : rightTrees) {
							root.left = (TreeNode) left;
							root.right = (TreeNode) right;
							trees.add(copy(root));
						}
					}
				}

				dp[i][i+step] = trees;
			}
		}

		return dp[1][n];
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
		Problem0095_UniqueBinarySearchTrees obj = new Problem0095_UniqueBinarySearchTrees();
		List<TreeNode> binarySearchTrees = obj.generateTrees1(1);
		System.out.println(binarySearchTrees);

		binarySearchTrees = obj.generateTrees1(2);
		System.out.println(binarySearchTrees);

		binarySearchTrees = obj.generateTrees1(3);
		System.out.println(binarySearchTrees);

		binarySearchTrees = obj.generateTrees1(4);
		System.out.println(binarySearchTrees);
	}
}
