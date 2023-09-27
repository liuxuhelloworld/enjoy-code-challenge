package leetcode;

import java.util.*;

public class Problem0103_BinaryTreeZigzagLevelOrderTraversal {
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

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}

		List<List<Integer>> ret = new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		int curLevel = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			List<Integer> curLevelList = new ArrayList<>(size);
			while (size-- > 0) {
				TreeNode cur = queue.poll();
				curLevelList.add(cur.val);

				if (cur.left != null) {
					queue.add(cur.left);
				}
				if (cur.right != null) {
					queue.add(cur.right);
				}
			}

			if (curLevel % 2 != 0) {
				Collections.reverse(curLevelList);
			}
			ret.add(curLevelList);
			curLevel++;
		}

		return ret;
	}

	public static void main(String[] args) {
		Problem0103_BinaryTreeZigzagLevelOrderTraversal obj = new Problem0103_BinaryTreeZigzagLevelOrderTraversal();

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(obj.zigzagLevelOrder(root));

		root = new TreeNode(1);
		System.out.println(obj.zigzagLevelOrder(root));
	}
}
