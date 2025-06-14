package TwoPointer;
//https://leetcode.com/problems/container-with-most-water/description/?envType=problem-list-v2&envId=oizxjoit

/**
 * 11. Container With Most Water
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * <p>
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * <p>
 * Return the maximum amount of water a container can store.
 * <p>
 * Notice that you may not slant the container.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 * <p>
 * Input: height = [1,1]
 * Output: 1
 */
public class ContainerWithMostRainWater {
    public static void main(String[] args) {
        int[] height = {8, 7, 2, 1};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int maxLeft = 0, maxRight = height.length - 1;
        while (maxLeft < maxRight) {
            int currentWidth = maxRight - maxLeft;
            int currentHeight = Math.min(height[maxLeft], height[maxRight]);
            maxArea = Math.max(maxArea, currentWidth * currentHeight);
            if (height[maxLeft] < height[maxRight]) {
                maxLeft++;
            } else {
                maxRight--;
            }
        }
        return maxArea;
    }
}
