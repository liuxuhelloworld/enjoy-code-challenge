package leetcode;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class Problem11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int len = height.length;

        int containerWidth;
        int containerHeight;
        int maxArea = 0;

        int i = 0, j = len-1;
        while(i < j) {
            containerWidth = j - i;
            containerHeight = Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, containerWidth*containerHeight);

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Problem11_ContainerWithMostWater obj = new Problem11_ContainerWithMostWater();
        System.out.println(obj.maxArea(new int[] {1, 3, 2, 5, 25, 24, 5}));
        System.out.println(obj.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(obj.maxArea(new int[] {1, 1}));
        System.out.println(obj.maxArea(new int[] {4, 3, 2, 1, 4}));
        System.out.println(obj.maxArea(new int[] {1, 2, 1}));
    }
}
