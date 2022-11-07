package leetcode.array;

/**
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/
 */
public class Problem4_MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int length1 = nums1.length;
		int length2 = nums2.length;

		if (length1 == 1 && length2 == 0) {
			return nums1[0];
		}

		if (length1 == 0 && length2 == 1) {
			return nums2[0];
		}

		int targetCnt1 = (int) Math.ceil((double)(length1+length2) / 2);
		int targetCnt2 = targetCnt1 + 1;

		int target1 = 0, target2 = 0;
		int cnt = 0;

		int i = 0, j = 0;
		while (i < length1 || j < length2) {
			cnt++;

			int min;
			if (i == length1) {
				min = nums2[j++];
			} else if (j == length2) {
				min = nums1[i++];
			} else {
				int val1 = nums1[i];
				int val2 = nums2[j];

				if (val1 <= val2) {
					min = val1;
					i++;
				} else {
					min = val2;
					j++;
				}
			}

			if (cnt == targetCnt1) {
				target1 = min;
			}
			if (cnt == targetCnt2) {
				target2 = min;
				break;
			}
		}

		if ((length1 + length2) % 2 == 1) {
			return target1;
		} else {
			return (double) (target1 + target2) / 2;
		}
	}

	public static void main(String[] args) {
		Problem4_MedianOfTwoSortedArrays obj = new Problem4_MedianOfTwoSortedArrays();
		System.out.println(obj.findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));
		System.out.println(obj.findMedianSortedArrays(new int[] {1}, new int[] {2}));
		System.out.println(obj.findMedianSortedArrays(new int[] {1, 2}, new int[] {-1, 3}));
		System.out.println(obj.findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}));
	}

}
