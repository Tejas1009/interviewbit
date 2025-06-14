package Arrays;

//https://leetcode.com/problems/median-of-two-sorted-arrays/description/

/**
 * 4. Median of Two Sorted Arrays
 * Hard
 * Topics
 * Companies
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class FindMedianSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int m1 = 0, m2 = 0, i = 0, j = 0;
        for (int k = 0; k <= n / 2; k++) {
            m2 = m1;
            if (i >= nums1.length) {
                m1 = nums2[j];
                j++;
                continue;
            }
            if (j >= nums2.length) {
                m1 = nums1[i];
                i++;
                continue;
            }
            if (nums1[i] <= nums2[j]) {
                m1 = nums1[i];
                i++;
            } else {
                m1 = nums2[j];
                j++;
            }
        }
        if (n % 2 == 0) {
            return (double) (m1 + m2) / 2;
        } else {
            return m1;
        }
    }
}
