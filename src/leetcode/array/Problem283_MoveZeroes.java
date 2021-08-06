package leetcode.array;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class Problem283_MoveZeroes {
	public void moveZeroes(int[] nums) {
		assert nums.length > 0;

		int len = nums.length;

		int slow = 0, fast = 0;
		while (true) {
			while (slow < len && nums[slow] != 0) {
				slow++;
			}
			if (slow == len) {
				break;
			}

			fast = Math.max(fast, slow + 1);
			while (fast < len && nums[fast] == 0) {
				fast++;
			}
			if (fast == len) {
				break;
			}

			int tmp = nums[slow];
			nums[slow] = nums[fast];
			nums[fast] = tmp;

			slow++;
			fast++;
		}
	}

	public static void main(String[] args) {
		Problem283_MoveZeroes obj = new Problem283_MoveZeroes();
		obj.moveZeroes(new int[] {0,1,0,3,12});
		obj.moveZeroes(new int[] {0});
	}
}
