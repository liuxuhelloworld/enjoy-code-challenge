package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/gray-code/
 */
public class Problem89_GrayCode {
	public List<Integer> grayCodeV1(int n) {
		assert n >= 1 && n <= 16;

		List<Integer> grayCodes = new ArrayList<>();

		int limit = 1;
		for (int i = 1; i <= n; i++) {
			limit *= 2;
		}

		Integer cur = 0;
		grayCodes.add(cur);

		dfs(grayCodes, cur, n, limit);

		return grayCodes;
	}

	private void dfs(List<Integer> bits, Integer cur, int n, int limit) {
		if (bits.size() == limit) {
			return;
		}

		for (int i = 0; i < n; i++) {
			Integer oneBitChange = cur ^ (1 << i);

			if (!bits.contains(oneBitChange)
				&& bits.size() < limit) {
				bits.add(oneBitChange);
				dfs(bits, oneBitChange, n, limit);
			}
		}
	}

	public List<Integer> grayCode2(int n) {
		assert n >= 1 && n <= 16;

		List<Integer> res = new ArrayList<>();
		res.add(0);

		for (int i = 0; i < n; i++) {
			int op = 1 << i;
			int len = res.size();
			for (int j = len-1; j >= 0; j--) {
				res.add(res.get(j) | op);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Problem89_GrayCode obj = new Problem89_GrayCode();
		System.out.println(obj.grayCode2(1));
		System.out.println(obj.grayCode2(2));
		System.out.println(obj.grayCode2(3));
	}
}
