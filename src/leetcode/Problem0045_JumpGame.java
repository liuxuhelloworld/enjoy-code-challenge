package leetcode;

/**
 * https://leetcode-cn.com/problems/jump-game-ii/
 */
public class Problem0045_JumpGame {
	public int jump(int[] nums) {
		int len = nums.length;

		if (len == 0 || len == 1) {
			return 0;
		}

		int[] jumps = new int[len]; // jumps[i] means the minimum jumps from nums[i] to the last element
		for (int i = 0; i < len-1; i++) {
			jumps[i] = -1;
		}
		jumps[len-1] = 0;

		for (int i = len-2; i >= 0; i--) {
			jumps[i] = minJumps(jumps, i, nums[i]);
		}

		return jumps[0];
	}

	private int minJumps(int[] jumps, int i, int val) {
		if (val == 0) {
			return -1;
		}

		int min = Integer.MAX_VALUE;
		for (int j = i + 1; j <= i + val && j < jumps.length; j++) {
			if (jumps[j] == -1) {
				continue;
			}
			min = Math.min(min, 1 + jumps[j]);
		}

		if (min == Integer.MAX_VALUE) {
			return -1;
		}

		return min;
	}

	public int jump2(int[] nums) {
		int len = nums.length;
		if (len == 1) {
			return 0;
		}

		int jump = 0;
		int curIdx = 0;
		int jumpIdx = -1;
		while (true) {
			int curVal = nums[curIdx];
			int canReachIdx = Math.min(curIdx + curVal, len-1);
			if (canReachIdx == len-1) {
				jump++;
				break;
			}

			int maxSum = Integer.MIN_VALUE;
			for (int i = curIdx+1; i <= canReachIdx ; i++) {
				int sum = i + nums[i];
				if (sum > maxSum) {
					maxSum = sum;
					jumpIdx = i;
				}
			}

			jump++;
			curIdx = jumpIdx;
		}

		return jump;
	}

	public static void main(String[] args) {
		Problem0045_JumpGame obj = new Problem0045_JumpGame();
		System.out.println(obj.jump2(new int[] {0}));
		System.out.println(obj.jump2(new int[] {2, 1}));
		System.out.println(obj.jump2(new int[] {2, 3, 1, 1, 4}));
		System.out.println(obj.jump2(new int[] {2, 3, 0, 1, 4}));
	}
}
