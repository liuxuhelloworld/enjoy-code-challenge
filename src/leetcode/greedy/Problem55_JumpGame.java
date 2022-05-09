package leetcode.greedy;

/**
 * https://leetcode-cn.com/problems/jump-game/
 */
public class Problem55_JumpGame {
	public boolean canJump(int[] nums) {
		int len = nums.length;

		int idx = len - 1;
		int lastZeroIdx;
		while ((lastZeroIdx = lastZero(nums, idx)) != -1) {
			idx = canJumpZeroLastIdx(nums, lastZeroIdx);
			if (idx == -1) {
				return false;
			}
		}

		return true;
	}

	private int lastZero(int[] nums, int idx) {
		for (int i = idx - 1; i >= 0; i--) {
			if (nums[i] == 0) {
				return i;
			}
		}

		return -1;
	}

	private int canJumpZeroLastIdx(int[] nums, int zeroIdx) {
		for (int i = zeroIdx - 1; i >= 0; i--) {
			if (nums[i] > (zeroIdx - i)) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		Problem55_JumpGame obj = new Problem55_JumpGame();
		System.out.println(obj.canJump(new int[] {0}));
		System.out.println(obj.canJump(new int[] {2, 0, 0}));
		System.out.println(obj.canJump(new int[] {2, 3, 1, 1, 4}));
		System.out.println(obj.canJump(new int[] {3, 2, 1, 0, 4}));
	}
}
