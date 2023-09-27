package leetcode;

/**
 * https://leetcode-cn.com/problems/jump-game-ii/
 */
public class Problem45_JumpGame {
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


	public static void main(String[] args) {
		Problem45_JumpGame obj = new Problem45_JumpGame();
		System.out.println(obj.jump(new int[] {0}));
		System.out.println(obj.jump(new int[] {2, 1}));
		System.out.println(obj.jump(new int[] {2, 3, 1, 1, 4}));
		System.out.println(obj.jump(new int[] {2, 3, 0, 1, 4}));
	}
}
