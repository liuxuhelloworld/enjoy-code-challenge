package leetcode;

/**
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/
 */
public class Problem0004_MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;

		if ((len1 + len2) % 2 == 0) {
			int cnt1 = (len1 + len2) / 2;
			int cnt2 = (len1 + len2) / 2 + 1;
			int val1 = findKthNumberOfTwoSortedArrays(nums1, nums2, cnt1);
			int val2 = findKthNumberOfTwoSortedArrays(nums1, nums2, cnt2);
			return (double)(val1 + val2) / 2;
		} else {
			int cnt = (len1 + len2) / 2 + 1;
			int val = findKthNumberOfTwoSortedArrays(nums1, nums2, cnt);
			return (double) val;
		}
	}

	private int findKthNumberOfTwoSortedArrays(int[] nums1, int[] nums2, int k) {
		int idx1 = 0, idx2 = 0;
		while (true) {
			if (idx1 >= nums1.length) {
				return nums2[idx2 + k - 1];
			}

			if (idx2 >= nums2.length) {
				return nums1[idx1 + k - 1];
			}

			if (k == 1) {
				return Math.min(nums1[idx1], nums2[idx2]);
			}

			int n = k/2;
			int newIdx1 = Math.min(idx1 + n - 1, nums1.length - 1);
			int newIdx2 = Math.min(idx2 + n - 1, nums2.length - 1);
			int val1 = nums1[newIdx1];
			int val2 = nums2[newIdx2];
			if (val1 <= val2) {
				k = k - (newIdx1 - idx1 + 1);
				idx1 = newIdx1 + 1;
			} else {
				k = k - (newIdx2 - idx2 + 1);
				idx2 = newIdx2 + 1;
			}
		}
	}

	public static void main(String[] args) {
		Problem0004_MedianOfTwoSortedArrays obj = new Problem0004_MedianOfTwoSortedArrays();
		System.out.println(obj.findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));
		System.out.println(obj.findMedianSortedArrays(new int[] {1}, new int[] {2}));
		System.out.println(obj.findMedianSortedArrays(new int[] {1, 2}, new int[] {-1, 3}));
		System.out.println(obj.findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}));
	}

}
