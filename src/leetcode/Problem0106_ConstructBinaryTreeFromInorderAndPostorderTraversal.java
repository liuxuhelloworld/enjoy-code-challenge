package leetcode;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class Problem0106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
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

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return recurBuildTree(inorder, 0, inorder.length - 1,
			postorder, 0, postorder.length - 1);
	}

	private TreeNode recurBuildTree(int[] inorder, int inStart, int inEnd,
	                                int[] postorder, int postStart, int postEnd) {
		if (postStart > postEnd) {
			return null;
		}

		int val = postorder[postEnd];
		TreeNode root = new TreeNode(val);

		if (postStart == postEnd) {
			return root;
		}

		int index = indexOf(inorder, inStart, inEnd, val);
		int leftTreeNodesNum = index - inStart;
		root.left = recurBuildTree(inorder, inStart, index - 1,
			postorder, postStart, postStart + leftTreeNodesNum - 1);
		root.right = recurBuildTree(inorder, index + 1, inEnd,
			postorder, postStart + leftTreeNodesNum, postEnd - 1);

		return root;
	}

	private int indexOf(int[] arr, int start, int end, int target) {
		for (int i = start; i <= end; i++) {
			if (arr[i] == target) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		Problem0106_ConstructBinaryTreeFromInorderAndPostorderTraversal obj =
			new Problem0106_ConstructBinaryTreeFromInorderAndPostorderTraversal();

		TreeNode root = obj.buildTree(new int[] {1,9,2,3,15,20,7}, new int[] {1,2,9,15,7,20,3});
		System.out.println(root);
	}
}
