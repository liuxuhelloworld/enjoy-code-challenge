package leetcode.dfs;

/**
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 */
public class Problem572_SubtreeOfAnotherTree {
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

	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		return dfs(root, subRoot);
	}

	private boolean dfs(TreeNode s, TreeNode t) {
		if (isSame(s, t)) {
			return true;
		}

		return s != null && (dfs(s.left, t) || dfs(s.right, t));
	}

	private boolean isSame(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		} else if (s != null && t == null) {
			return false;
		} else if (s == null && t != null) {
			return false;
		} else {
			if (s.val != t.val) {
				return false;
			} else {
				return isSame(s.left, t.left) && isSame(s.right, t.right);
			}
		}
	}

	public static void main(String[] args) {
		Problem572_SubtreeOfAnotherTree obj = new Problem572_SubtreeOfAnotherTree();

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(2);

		TreeNode subRoot = new TreeNode(4);
		subRoot.left = new TreeNode(1);
		subRoot.right = new TreeNode(2);

		System.out.println(obj.isSubtree(root, subRoot));

		root.left.right.left = new TreeNode(0);

		System.out.println(obj.isSubtree(root, subRoot));
	}
}
