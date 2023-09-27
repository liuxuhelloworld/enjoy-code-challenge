package leetcode;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class Problem0033_SearchInRotatedSortedArray {
  public int search(int[] nums, int target) {
    if (nums.length == 0) {
      return -1;
    }

    int left = 0, right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left)/2;
      if (nums[mid] == target) {
        return mid;
      }

      if (nums[0] <= nums[mid]) {
        // left part is ordered
        if (target >= nums[0] && target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        // right part is ordered
        if (target > nums[mid] && target <= nums[nums.length-1]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    Problem0033_SearchInRotatedSortedArray obj = new Problem0033_SearchInRotatedSortedArray();
    System.out.println(obj.search(new int[] {3, 1}, 1));
    System.out.println(obj.search(new int[] {3, 4, 5, 6, 7, 8, 9, 0, 1, 2}, 5));
    System.out.println(obj.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 5));
    System.out.println(obj.search(new int[] {1}, 0));
    System.out.println(obj.search(new int[] {1}, 1));
    System.out.println(obj.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0));
    System.out.println(obj.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 3));
  }
}
