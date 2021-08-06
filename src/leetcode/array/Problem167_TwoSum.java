package leetcode.array;

/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class Problem167_TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		int left = 0, right = numbers.length - 1;
		while (left < right) {
			int sum = numbers[left] + numbers[right];
			if (sum == target) {
				break;
			} else if (sum > target) {
				right--;
			} else {
				left++;
			}
		}
		return new int[] {left+1, right+1};
	}

	public static void main(String[] args) {
		Problem167_TwoSum obj = new Problem167_TwoSum();
		System.out.println(obj.twoSum(new int[] {2,7,11,15}, 9));
		System.out.println(obj.twoSum(new int[] {2,3,4}, 6));
		System.out.println(obj.twoSum(new int[] {-1,0}, -1));
	}
}
