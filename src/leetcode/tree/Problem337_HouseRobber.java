package leetcode.tree;

/**
 * https://leetcode.cn/problems/house-robber-iii/
 */
public class Problem337_HouseRobber {
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

	public int rob(TreeNode root) {
		int[] rob = dfs(root);
		return Math.max(rob[0], rob[1]);
	}

	private int[] dfs(TreeNode node) {
		if (node == null) {
			return new int[] {0, 0};
		}

		int[] left = dfs(node.left);
		int[] right = dfs(node.right);
		int val = node.val;

		int leftSelected = left[0];
		int leftUnselected = left[1];
		int rightSelected = right[0];
		int rightUnselected = right[1];
		int nodeSelected = val + leftUnselected + rightUnselected;
		int nodeUnselected = Math.max(leftSelected, leftUnselected) + Math.max(rightSelected, rightUnselected);

		return new int[] {nodeSelected, nodeUnselected};
	}

	public static void main(String[] args) {
		Problem337_HouseRobber obj = new Problem337_HouseRobber();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(1);

		System.out.println(obj.rob(root));
	}
}
