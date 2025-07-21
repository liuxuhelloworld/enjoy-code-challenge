package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/gray-code/
 */
public class Problem0089_GrayCode {
	public List<Integer> grayCode(int n) {
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
		Problem0089_GrayCode obj = new Problem0089_GrayCode();
		System.out.println(obj.grayCode(1));
		System.out.println(obj.grayCode(2));
		System.out.println(obj.grayCode(3));
	}
}
