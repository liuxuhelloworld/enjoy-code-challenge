package leetcode;

/**
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 */
public class Problem0617_MergeTwoBinaryTrees {
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

	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return null;
		} else if (root1 != null && root2 == null) {
			return root1;
		} else if (root1 == null && root2 != null) {
			return root2;
		} else {
			TreeNode left = mergeTrees(root1.left, root2.left);
			TreeNode right = mergeTrees(root1.right, root2.right);
			root1.val = root1.val + root2.val;
			root1.left = left;
			root1.right = right;

			return root1;
		}
	}

	public static void main(String[] args) {
		Problem0617_MergeTwoBinaryTrees obj = new Problem0617_MergeTwoBinaryTrees();
		TreeNode root1 = new TreeNode(1);

		TreeNode root2 = new TreeNode(2);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(3);
		root2.left.right = new TreeNode(4);
		root2.right.right = new TreeNode(7);

		TreeNode merged = obj.mergeTrees(root1, root2);
		System.out.println(merged);
	}
}
