package leetcode;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class Problem0080_RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		int len = nums.length;
		assert len > 0;

		int pos = 1;
		int cnt = 1;
		int lastNum = nums[0];
		for (int i = 1; i < len; i++) {
			int curNum = nums[i];

			if (curNum == lastNum) {
				cnt++;
				if (cnt > 2) {
					continue;
				} else {
					nums[pos++] = curNum;
				}
			} else {
				nums[pos++] = curNum;
				cnt = 1;
				lastNum = curNum;
			}
		}

		return pos;
	}

	public static void main(String[] args) {
		Problem0080_RemoveDuplicatesFromSortedArray obj = new Problem0080_RemoveDuplicatesFromSortedArray();

		int[] nums = new int[] {1,1,1,2,2,3};
		System.out.println(obj.removeDuplicates(nums));

		nums = new int[] {0,0,1,1,1,1,2,3,3};
		System.out.println(obj.removeDuplicates(nums));
	}
}
