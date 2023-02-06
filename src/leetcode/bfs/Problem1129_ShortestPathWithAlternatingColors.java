package leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.cn/problems/shortest-path-with-alternating-colors/
 */
public class Problem1129_ShortestPathWithAlternatingColors {
	public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
		int[] shortestPathLengthWithRedLastPath = new int[n];
		shortestPathLengthWithRedLastPath[0] = 0;
		for (int i = 1; i < n; i++) {
			shortestPathLengthWithRedLastPath[i] = -1;
		}

		int[] shortestPathLengthWithBlueLastPath = new int[n];
		shortestPathLengthWithBlueLastPath[0] = 0;
		for (int i = 1; i < n; i++) {
			shortestPathLengthWithBlueLastPath[i] = -1;
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);

		while (!queue.isEmpty()) {
			Set<Integer> nextRound = new HashSet<>();

			int size = queue.size();
			while (size-- > 0) {
				int v = queue.poll();

				if (shortestPathLengthWithBlueLastPath[v] != -1) {
					int length = shortestPathLengthWithBlueLastPath[v] + 1;
					for (int i = 0; i < redEdges.length; i++) {
						if (redEdges[i][0] == v) {
							int next = redEdges[i][1];

							if (shortestPathLengthWithRedLastPath[next] == -1) {
								shortestPathLengthWithRedLastPath[next] = length;
								nextRound.add(next);
							} else {
								if (length < shortestPathLengthWithRedLastPath[next]) {
									shortestPathLengthWithRedLastPath[next] = length;
								}
							}
						}
					}
				}

				if (shortestPathLengthWithRedLastPath[v] != -1) {
					int length = shortestPathLengthWithRedLastPath[v] + 1;
					for (int i = 0; i < blueEdges.length; i++) {
						if (blueEdges[i][0] == v) {
							int next = blueEdges[i][1];

							if (shortestPathLengthWithBlueLastPath[next] == -1) {
								shortestPathLengthWithBlueLastPath[next] = length;
								nextRound.add(next);
							} else {
								if (length < shortestPathLengthWithBlueLastPath[next]) {
									shortestPathLengthWithBlueLastPath[next] = length;
								}
							}
						}
					}
				}
			}

			queue.addAll(nextRound);
		}

		int[] shortestPathLength = new int[n];
		for (int i = 0; i < n; i++) {
			int withRedLastPath = shortestPathLengthWithRedLastPath[i];
			int withBlueLastPath = shortestPathLengthWithBlueLastPath[i];

			if (withRedLastPath == -1
				&& withBlueLastPath == -1) {
				shortestPathLength[i] = -1;
			} else if (withRedLastPath == -1) {
				shortestPathLength[i] = withBlueLastPath;
			} else if (withBlueLastPath == -1) {
				shortestPathLength[i] = withRedLastPath;
			} else {
				shortestPathLength[i] = Math.min(withRedLastPath, withBlueLastPath);
			}
		}

		return shortestPathLength;
	}

	public static void main(String[] args) {
		Problem1129_ShortestPathWithAlternatingColors obj = new Problem1129_ShortestPathWithAlternatingColors();
		int[][] redEdges = new int[][] {
			{1,2},{1,7},{2,2},{4,2},{5,1},{2,6},{6,7},{7,0},{4,6},{0,6},{2,1},{2,7},{4,3},{4,4},{0,5}};
		int[][] blueEdges = new int[][] {
			{4,6},{3,3},{3,7},{7,5},{3,0},{2,0},{7,6},{0,4},{7,1},{6,7},{0,0},{6,6},{4,1},{6,2},{6,0},{1,6}};

		int[] shortestPath = obj.shortestAlternatingPaths(8, redEdges, blueEdges);
		System.out.println(shortestPath);
	}
}
