package leetcode.tree;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class Problem105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
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

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return recurBuildTree(preorder, 0, preorder.length-1,
			inorder, 0, inorder.length-1);
	}

	private TreeNode recurBuildTree(int[] preorder, int preStart, int preEnd,
	                                int[] inorder, int inStart, int inEnd) {
		if (preStart > preEnd) {
			return null;
		}

		int val = preorder[preStart];
		TreeNode root = new TreeNode(val);

		if (preStart == preEnd) {
			return root;
		}

		int index = indexOf(inorder, inStart, inEnd, val);
		int leftTreeNodesNum = index - inStart;
		root.left = recurBuildTree(preorder, preStart + 1, preStart + leftTreeNodesNum,
			inorder, inStart, index - 1);
		root.right = recurBuildTree(preorder, preStart + leftTreeNodesNum + 1, preEnd,
			inorder, index + 1, inEnd);

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
		Problem105_ConstructBinaryTreeFromPreorderAndInorderTraversal obj =
			new Problem105_ConstructBinaryTreeFromPreorderAndInorderTraversal();

		TreeNode root = obj.buildTree(new int[] {3,9,1,2,20,15,7}, new int[] {1,9,2,3,15,20,7});
		System.out.println(root);
	}
}
