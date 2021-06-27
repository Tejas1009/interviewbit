package Others.ArraysAndString;

/*Given an integer array nums, find three numbers whose product is maximum and return the maximum product.



        Example 1:

        Input: nums = [1,2,3]
        Output: 6
        Example 2:

        Input: nums = [1,2,3,4]
        Output: 24
        Example 3:

        Input: nums = [-1,-2,-3]
        Output: -6


        Constraints:

        3 <= nums.length <= 104
        -1000 <= nums[i] <= 1000*/
public class MaximumProductOfThreeNumbers {
    //1    2    3   -7  4   5   6   -8
    //
    public int maximumProduct(int[] nums) {
        int res = 0, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max1 < nums[i]) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (max2 < nums[i]) {
                max3 = max2;
                max2 = nums[i];
            } else if (max3 < nums[i]) {
                max3 = nums[i];
            }

            if (min1 > nums[i]) {
                min2 = min1;
                min1 = nums[i];
            } else if (min2 > nums[i]) {
                min2 = nums[i];
            }
        }
        res = Math.max(min1 * min2 * max1, max1 * max2 * max3);
        return res;
    }

    public static void main(String[] args) {
        MaximumProductOfThreeNumbers m = new MaximumProductOfThreeNumbers();
        int nums[] = {1, 2, 3};
        int nums1[] = {1, 2, 3, 4};
        int nums2[] = {-1, -2, -3};
        int nums3[] = {1, 2, 3, -7, 4, 5, 6, -8};
        //System.out.println(m.maximumProduct(nums));
        //System.out.println(m.maximumProduct(nums1));
        System.out.println(m.maximumProduct(nums3));
    }
}