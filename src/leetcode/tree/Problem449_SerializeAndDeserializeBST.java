package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/serialize-and-deserialize-bst/
 */
public class Problem449_SerializeAndDeserializeBST {
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

	public String serialize(TreeNode root) {
		if (root == null) {
			return null;
		}

		List<Integer> inOrderList = new ArrayList<>();
		inOrderTraverse(root, inOrderList);

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < inOrderList.size(); i++) {
			short cur = inOrderList.get(i).shortValue();

			int val = (cur & 0b1111000000000000) >>> 12;
			char ch = map(val);
			builder.append(ch);

			val = (cur & 0b0000111100000000) >>> 8;
			ch = map(val);
			builder.append(ch);

			val = (cur & 0b0000000011110000) >>> 4;
			ch = map(val);
			builder.append(ch);

			val = cur & 0b0000000000001111;
			ch = map(val);
			builder.append(ch);
		}

		return builder.toString();
	}

	private void inOrderTraverse(TreeNode node, List<Integer> inOrderList) {
		if (node == null) {
			return;
		}

		inOrderList.add(node.val);
		inOrderTraverse(node.left, inOrderList);
		inOrderTraverse(node.right, inOrderList);
	}

	private char map(int val) {
		char ch = 0;
		switch (val) {
			case 0:
				ch = '0';
				break;
			case 1:
				ch = '1';
				break;
			case 2:
				ch = '2';
				break;
			case 3:
				ch = '3';
				break;
			case 4:
				ch = '4';
				break;
			case 5:
				ch = '5';
				break;
			case 6:
				ch = '6';
				break;
			case 7:
				ch = '7';
				break;
			case 8:
				ch = '8';
				break;
			case 9:
				ch = '9';
				break;
			case 10:
				ch = 'A';
				break;
			case 11:
				ch = 'B';
				break;
			case 12:
				ch = 'C';
				break;
			case 13:
				ch = 'D';
				break;
			case 14:
				ch = 'E';
				break;
			case 15:
				ch = 'F';
				break;
			default:
				break;
		}

		return ch;
	}

	public TreeNode deserialize(String data) {
		if (data == null
			|| data.isEmpty()) {
			return null;
		}

		char[] chars = data.toCharArray();
		int length = chars.length;

		short[] inOrderArray = new short[length / 4];

		for (int i = 0; i < inOrderArray.length; i++) {
			char ch1 = chars[i*4];
			char ch2 = chars[i*4 + 1];
			char ch3 = chars[i*4 + 2];
			char ch4 = chars[i*4 + 3];

			int cur = 0;

			int val = map(ch1);
			cur = cur | (val << 12);

			val = map(ch2);
			cur = cur | (val << 8);

			val = map(ch3);
			cur = cur | (val << 4);

			val = map(ch4);
			cur = cur | val;

			inOrderArray[i] = (short) cur;
		}

		return rebuild(inOrderArray, 0, inOrderArray.length - 1);
	}

	private int map(char ch) {
		int val = 0;
		switch (ch) {
			case '0':
				val = 0;
				break;
			case '1':
				val = 1;
				break;
			case '2':
				val = 2;
				break;
			case '3':
				val = 3;
				break;
			case '4':
				val = 4;
				break;
			case '5':
				val = 5;
				break;
			case '6':
				val = 6;
				break;
			case '7':
				val = 7;
				break;
			case '8':
				val = 8;
				break;
			case '9':
				val = 9;
				break;
			case 'A':
				val = 10;
				break;
			case 'B':
				val = 11;
				break;
			case 'C':
				val = 12;
				break;
			case 'D':
				val = 13;
				break;
			case 'E':
				val = 14;
				break;
			case 'F':
				val = 15;
				break;
			default:
				break;
		}

		return val;
	}

	private TreeNode rebuild(short[] inOrderArray, int start, int end) {
		if (start > end) {
			return null;
		}

		short val = inOrderArray[start];
		TreeNode node = new TreeNode(val);

		int lessThan = -1;
		int greaterThan = -1;
		for (int i = start + 1; i <= end; i++) {
			if (inOrderArray[i] < val) {
				lessThan = i;
			} else if (inOrderArray[i] > val) {
				greaterThan = i;
				break;
			}
		}

		if (lessThan != -1) {
			node.left = rebuild(inOrderArray, start + 1, lessThan);
		}
		if (greaterThan != -1) {
			node.right = rebuild(inOrderArray, greaterThan, end);
		}

		return node;
	}

	public static void main(String[] args) {
		Problem449_SerializeAndDeserializeBST obj = new Problem449_SerializeAndDeserializeBST();

		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);

		String str = obj.serialize(root);
		TreeNode copy = obj.deserialize(str);
	}
}
