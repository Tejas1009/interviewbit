package Others.ArraysAndString;

import java.util.Arrays;

/*Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

        You must write an algorithm that runs in O(n) time and without using the division operation.



        Example 1:

        Input: nums = [1,2,3,4]
        Output: [24,12,8,6]
        Example 2:

        Input: nums = [-1,1,0,-3,3]
        Output: [0,0,9,0,0]


        Constraints:

        2 <= nums.length <= 105
        -30 <= nums[i] <= 30
        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.


        Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)*/
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        //we can have 2 arrays left and right
        //left will store all product till ith index from start
        //right will store all product till ith index from end
        int res[] = new int[nums.length];
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1, j = nums.length - 2; i < nums.length && j >= 0; i++, j--) {
            left[i] = left[i - 1] * nums[i];
            right[j] = right[j + 1] * nums[j];
        }
        res[0] = right[1];
        res[nums.length - 1] = left[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            res[i] = left[i - 1] * right[i + 1];
        }
        return res;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf p = new ProductOfArrayExceptSelf();
        int nums[] = {1, 2, 3, 4};
        int nums1[] = {1, 2};
        int nums2[] = {1, 2, 3, 2, 5, 4};
        //Arrays.stream(p.productExceptSelf(nums)).forEach(System.out::println);
        //Arrays.stream(p.productExceptSelf(nums1)).forEach(System.out::println);
        Arrays.stream(p.productExceptSelf(nums2)).forEach(System.out::println);
    }
}