package leetcode;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 */
public class Problem96_UniqueBinarySearchTrees {
	public int numTrees(int n) {
		assert n >= 1 && n <= 19;

		int[] num = new int[n+1];
		num[0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= i-1; j++) {
				num[i] += num[j] * num[i-1-j];
			}
		}

		return num[n];
	}

	public static void main(String[] args) {
		Problem96_UniqueBinarySearchTrees obj = new Problem96_UniqueBinarySearchTrees();
		System.out.println(obj.numTrees(1));
		System.out.println(obj.numTrees(2));
		System.out.println(obj.numTrees(3));
		System.out.println(obj.numTrees(4));
		System.out.println(obj.numTrees(5));
	}
}
