package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/all-paths-from-source-to-target/
 */
public class Problem797_AllPathsFromSourceToTarget {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> path = new ArrayList<>();

		path.add(0);
		dfs(graph, 0, graph.length - 1, result, path);

		return result;
	}

	private void dfs(int[][] graph, int src, int dst, List<List<Integer>> result, List<Integer> path) {
		if (src == dst) {
			result.add(path.stream().collect(Collectors.toList()));
			return;
		}

		for (int next : graph[src]) {
			path.add(next);
			dfs(graph, next, dst, result, path);
			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] args) {
		Problem797_AllPathsFromSourceToTarget obj = new Problem797_AllPathsFromSourceToTarget();

		int[][] graph = new int[][] {
			{1, 2},
			{3},
			{3},
			{}
		};
		System.out.println(obj.allPathsSourceTarget(graph));

		graph = new int[][] {
			{4, 3, 1},
			{3, 2, 4},
			{3},
			{4},
			{}
		};
		System.out.println(obj.allPathsSourceTarget(graph));
	}
}
