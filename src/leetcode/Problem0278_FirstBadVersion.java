package leetcode;

/**
 * https://leetcode-cn.com/problems/first-bad-version/
 */
public class Problem0278_FirstBadVersion {
	public int firstBadVersion(int n) {
		assert n >= 1;

		int low = 1, high = n;
		while (low < high) {
			int mid = low + (high - low)/2;
			if (isBadVersion(mid)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}

		return high;
	}

	private boolean isBadVersion(int n) {
		return n >= 1;
	}

	public static void main(String[] args) {
		Problem0278_FirstBadVersion obj = new Problem0278_FirstBadVersion();
		System.out.println(obj.firstBadVersion(1));
	}
}
