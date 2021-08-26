package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/flood-fill/
 */
public class Problem733_FloodFill {
	int[] dx = new int[] {0, -1, 0, 1};
	int[] dy = new int[] {1, 0, -1, 0};

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int targetColor = image[sr][sc];
		if (targetColor == newColor) {
			return image;
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {sr, sc});
		image[sr][sc] = newColor;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newRow = cur[0] + dx[i];
				int newCol = cur[1] + dy[i];
				if (newRow >= 0 && newRow < image.length
					&& newCol >= 0 && newCol < image[0].length
					&& image[newRow][newCol] == targetColor) {
					queue.add(new int[] {newRow, newCol});
					image[newRow][newCol] = newColor;
				}
			}
		}

		return image;
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