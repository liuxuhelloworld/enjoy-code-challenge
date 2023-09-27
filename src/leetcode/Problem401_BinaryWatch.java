package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/binary-watch/
 */
public class Problem401_BinaryWatch {
	public List<String> readBinaryWatch(int turnedOn) {
		int[] hourVal = new int[] {8, 4, 2, 1};
		int[] minuteVal = new int[] {32, 16, 8, 4, 2, 1};

		List<String> result = new ArrayList<>();

		for (int hourTurned = 0; hourTurned <= turnedOn; hourTurned++) {
			int minuteTurned = turnedOn - hourTurned;

			Set<Integer> hourResult = new HashSet<>();
			boolean[] hourSelected = new boolean[hourVal.length];
			backtrack(hourResult, hourSelected, hourVal, hourTurned, 11);

			Set<Integer> minuteResult = new HashSet<>();
			boolean[] minuteSelected = new boolean[minuteVal.length];
			backtrack(minuteResult, minuteSelected, minuteVal, minuteTurned, 59);

			for (Integer hour : hourResult) {
				for (Integer minute : minuteResult) {
					String time = hour + ":" + (minute >= 10 ? "" + minute : "0" + minute);
					result.add(time);
				}
			}
		}

		return result;
	}

	private void backtrack(Set<Integer> result, boolean[] selected, int[] nums, int remain, int max) {
		if (remain > nums.length) {
			return;
		}

		if (remain == 0) {
			int sum = sum(nums, selected);
			if (sum <= max) {
				result.add(sum);
			}
			return;
		}

		for (int i = 0; i < selected.length; i++) {
			if (!selected[i]) {
				selected[i] = true;
				backtrack(result, selected, nums, remain - 1, max);
				selected[i] = false;
			}
		}
	}

	private int sum(int[] nums, boolean[] selected) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (selected[i]) {
				sum += nums[i];
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		Problem401_BinaryWatch obj = new Problem401_BinaryWatch();
		System.out.println(obj.readBinaryWatch(9));
		System.out.println(obj.readBinaryWatch(2));
		System.out.println(obj.readBinaryWatch(0));
		System.out.println(obj.readBinaryWatch(1));
	}
}
