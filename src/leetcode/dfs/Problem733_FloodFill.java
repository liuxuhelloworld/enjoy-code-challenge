package leetcode.dfs;

/**
 * https://leetcode-cn.com/problems/flood-fill/
 */
public class Problem733_FloodFill {
	int[] dx = new int[] {0, -1, 0, 1};
	int[] dy = new int[] {1, 0, -1, 0};

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		dfs(image, sr, sc, image[sr][sc], newColor);
		return image;
	}

	private void dfs(int[][] image, int curRow, int curCol, int startColor, int newColor) {
		int curColor = image[curRow][curCol];
		if (curColor == newColor) {
			return;
		}

		if (curColor == startColor) {
			image[curRow][curCol] = newColor;
			for (int i = 0; i < 4; i++) {
				int newRow = curRow + dx[i];
				int newCol = curCol + dy[i];
				if (newRow >= 0
					&& newRow < image.length
					&& newCol >= 0
					&& newCol < image[0].length) {
					dfs(image, curRow + dx[i], curCol + dy[i], startColor, newColor);
				}
			}
		}
	}

	public static void main(String[] args) {
		Problem733_FloodFill obj = new Problem733_FloodFill();
		int[][] image = new int[][] {
			{1,1,1},
			{1,1,0},
			{1,0,1}
		};

		image = obj.floodFill(image, 1, 1, 2);
		System.out.println(image);
	}
}
