package leetcode.dfs;

/**
 * https://leetcode-cn.com/problems/number-of-provinces/
 */
public class Problem547_NumberOfProvinces {
	public int findCircleNum(int[][] isConnected) {
		int len = isConnected.length;

		boolean[] visited = new boolean[len];

		int num = 0;
		for (int i = 0; i < len; i++) {
			if (!visited[i]) {
				num++;
				dfs(isConnected, visited, i);
			}
		}

		return num;
	}

	private void dfs(int[][] isConnected, boolean[] visited, int i) {
		visited[i] = true;
		for (int j = 0; j < isConnected.length; j++) {
			if (isConnected[i][j] == 1
				&& !visited[j]) {
				dfs(isConnected, visited, j);
			}
		}
	}

	public static void main(String[] args) {
		Problem547_NumberOfProvinces obj = new Problem547_NumberOfProvinces();
		int[][] isConnected = new int[][] {
			{1, 0, 0, 1},
			{0, 1, 1, 0},
			{0, 1, 1, 1},
			{1, 0, 1, 1}
		};
		System.out.println(obj.findCircleNum(isConnected));

		isConnected = new int[][] {
			{1, 0, 0},
			{0, 1, 0},
			{0, 0, 1}
		};
		System.out.println(obj.findCircleNum(isConnected ));
	}
}
