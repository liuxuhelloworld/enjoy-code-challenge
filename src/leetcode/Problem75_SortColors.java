package leetcode;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 */
public class Problem75_SortColors {
	public void sortColors(int[] nums) {
		int len = nums.length;
		if (len == 0 || len == 1) {
			return;
		}

		int p0 = 0, p2 = len - 1;
		for (int i = 0; i <= p2; i++) {
			while (i <= p2 && nums[i] == 2) {
				swap(nums, p2, i);
				p2--;
			}
			if (nums[i] == 0) {
				swap(nums, p0, i);
				p0++;
			}
		}
	}

	public void sortColors2(int[] nums) {
		int len = nums.length;
		if (len == 0 || len == 1) {
			return;
		}

		int p0 = 0, p1 = 0;
		for (int i = 0; i < len; i++) {
			int cur = nums[i];
			if (cur == 0) {
				swap(nums, p0, i);
				if (p0 < p1) {
					swap(nums, p1, i);
				}
				p0++;
				p1++;
			}
			if (cur == 1) {
				swap(nums, p1, i);
				p1++;
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		Problem75_SortColors obj = new Problem75_SortColors();
		int[] nums = new int[] {2, 0, 2, 1, 1, 0};
		obj.sortColors2(nums);

		nums = new int[] {2, 0, 1};
		obj.sortColors2(nums);
	}
}
