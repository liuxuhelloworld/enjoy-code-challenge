package leetcode.tree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class Problem102_BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}

		List<List<Integer>> ret = new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();

			List<Integer> curLevel = new ArrayList<>(size);
			while (size-- > 0) {
				TreeNode cur = queue.poll();
				curLevel.add(cur.val);

				if (cur.left != null) {
					queue.add(cur.left);
				}
				if (cur.right != null) {
					queue.add(cur.right);
				}
			}

			ret.add(curLevel);
		}

		return ret;
	}

	public static void main(String[] args) {
		Problem102_BinaryTreeLevelOrderTraversal obj = new Problem102_BinaryTreeLevelOrderTraversal();

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(obj.levelOrder(root));

		root = new TreeNode(1);
		System.out.println(obj.levelOrder(root));
	}
}
