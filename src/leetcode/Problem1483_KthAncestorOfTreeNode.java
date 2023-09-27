package leetcode;

public class Problem1483_KthAncestorOfTreeNode {
	static class TreeAncestor {
		private int[][] ancestor; // ancestor[i][j] represents node i's 2^j(th) ancestor
		                          // ancestor[i][j] = ancestor[ancestor[i][j-1]][j-1]

		public TreeAncestor(int n, int[] parent) {
			ancestor = new int[n][16];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 16; j++) {
					ancestor[i][j] = -1;
				}
			}

			for (int i = 0; i < n; i++) {
				ancestor[i][0] = parent[i];
			}

			for (int j = 1; j < 16; j++) {
				for (int i = 0; i < n; i++) {
					if (ancestor[i][j-1] != -1) {
						ancestor[i][j] = ancestor[ancestor[i][j-1]][j-1];
					}
				}
			}
		}

		public int getKthAncestor(int node, int k) {
			for (int j = 0; j < 16; j++) {
				if (((k >> j) & 1) != 0) {
					node = ancestor[node][j];
					if (node == -1) {
						return -1;
					}
				}
			}

			return node;
		}
	}

	public static void main(String[] args) {
		TreeAncestor treeAncestor = new TreeAncestor(7, new int[] {-1, 0, 0, 1, 1, 2, 2});
		System.out.println(treeAncestor.getKthAncestor(3, 1));
		System.out.println(treeAncestor.getKthAncestor(5, 2));
		System.out.println(treeAncestor.getKthAncestor(6, 3));
	}
}
