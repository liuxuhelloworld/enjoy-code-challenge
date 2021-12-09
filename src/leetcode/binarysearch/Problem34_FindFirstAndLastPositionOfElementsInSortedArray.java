package leetcode.search;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class Problem34_FindFirstAndLastPositionOfElementsInSortedArray {
  public int[] searchRange(int[] nums, int target) {
    if (nums.length == 0) {
      return new int[] {-1, -1};
    }

    int leftest = -1, rightest = -1;
    int index = binarySearch(nums, 0, nums.length-1, target);
    if (index == -1) {
      return new int[] {-1, -1};
    } else {
      leftest = rightest = index;
    }

    while ((index = binarySearch(nums, 0, leftest-1, target)) != -1) {
      leftest = index;
    }

    while ((index = binarySearch(nums, rightest+1, nums.length-1, target)) != -1) {
      rightest = index;
    }

    return new int[] {leftest, rightest};
  }

  private int binarySearch(int[] nums, int left, int right, int target) {
    if (left > right) {
      return -1;
    }

    if ((left >= 0 && target < nums[left])
        || (right <= nums.length-1 && target > nums[right])) {
      return -1;
    }

    while (left <= right) {
      int mid = left + (right - left)/2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    Problem34_FindFirstAndLastPositionOfElementsInSortedArray obj =
        new Problem34_FindFirstAndLastPositionOfElementsInSortedArray();
    System.out.println(Arrays.toString(obj.searchRange(new int[] {1}, 1)));
    System.out.println(Arrays.toString(obj.searchRange(new int[] {}, 0)));
    System.out.println(Arrays.toString(obj.searchRange(new int[] {0}, 0)));
    System.out.println(Arrays.toString(obj.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8)));
    System.out.println(Arrays.toString(obj.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 6)));
  }
}
