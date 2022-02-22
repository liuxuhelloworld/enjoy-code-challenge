package leetcode.twopointers;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class Problem283_MoveZeroes {
	public void moveZeroes(int[] nums) {
		int len = nums.length;

		int slow = 0;
		for (int fast = 0; fast < len; fast++) {
			if (nums[fast] != 0) {
				nums[slow] = nums[fast];
				slow++;
			}
		}

		for (int i = slow; i < len; i++) {
			nums[i] = 0;
		}
	}

	public static void main(String[] args) {
		Problem283_MoveZeroes obj = new Problem283_MoveZeroes();
		obj.moveZeroes(new int[] {0,1,0,3,12});
		obj.moveZeroes(new int[] {0});
	}
}
