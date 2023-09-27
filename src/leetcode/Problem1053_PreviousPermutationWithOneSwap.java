package leetcode;

import java.util.Arrays;

public class Problem1053_PreviousPermutationWithOneSwap {
	public int[] prevPermOpt1(int[] arr) {
		int i = arr.length - 1;
		while (i > 0) {
			if (arr[i - 1] > arr[i]) {
				break;
			}
			i--;
		}

		if (i == 0) {
			return arr;
		}

		int leftIdx = i - 1;
		int rightIdx = i;

		int curVal = arr[i];
		int prevVal = arr[i - 1];

		int maxVal = curVal;
		int j = i + 1;
		while (j < arr.length) {
			if (arr[j] > curVal && arr[j] < prevVal) {
				if (arr[j] > maxVal) {
					rightIdx = j;
					maxVal = arr[j];
				}
			}
			j++;
		}

		swap(arr, leftIdx, rightIdx);

		return arr;
	}

	private void swap(int[] arr, int left, int right) {
		int tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
	}

	public static void main(String[] args) {
		Problem1053_PreviousPermutationWithOneSwap obj = new Problem1053_PreviousPermutationWithOneSwap();
		System.out.println(Arrays.toString(obj.prevPermOpt1(new int[]{6,1,5,9,1,1,9,7,7,9,7,6,2,7,3,4,5,1,7,6,3,5,3,1,4,7,1,1,8,8,9,1,9,5,1,6,5,4,7,3,2,7,4,9,7,6,2,5,7,4,3,7,5,5,4,4,2,1,3,1,6,4,8,7,5,9,3,1,4,4,7,5,3,7,2,4,4,8,5,4,8,1,1,3,4,3,5,4,8,1,5,4,9,8,4,5,3,1,1,3})));
	}
}
