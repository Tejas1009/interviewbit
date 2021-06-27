package Others.ArraysAndString;

import java.util.Arrays;

/*Given an array nums of non-negative integers, return an array consisting of all the even elements of nums, followed by all the odd elements of nums.

        You may return any answer array that satisfies this condition.



        Example 1:

        Input: nums = [3,1,2,4]
        Output: [2,4,3,1]
        The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.


        Note:

        1 <= nums.length <= 5000
        0 <= nums[i] <= 5000*/
public class SortArrayByParity {
    //3,1,2,4

    //2,1,3,4

    //2,4,3,1
    public int[] sortArrayByParity(int[] nums) {
        int res[] = new int[nums.length];
        int even = 0, odd = 0;
        while (even < nums.length && odd < nums.length) {
            while (odd < nums.length && nums[odd] % 2 == 0) odd++;
            even = odd + 1;
            while (even < nums.length && nums[even] % 2 != 0) even++;
            if (even < nums.length && odd < nums.length && odd < even) {
                //swap
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        SortArrayByParity s = new SortArrayByParity();
        int nums[] = {3, 1, 2, 4};
        int nums1[] = {2, 1, 3, 4};
        int nums2[] = {9, 3, 8, 6, 7, 2, 3};
        //Arrays.stream(s.sortArrayByParity(nums)).forEach(System.out::println);
        //Arrays.stream(s.sortArrayByParity(nums1)).forEach(System.out::println);
        Arrays.stream(s.sortArrayByParity(nums2)).forEach(System.out::println);
    }
}