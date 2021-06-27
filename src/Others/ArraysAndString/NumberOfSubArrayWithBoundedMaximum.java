package Others.ArraysAndString;

/*795. Number of Subarrays with Bounded Maximum
        Medium

        1208

        79

        Add to List

        Share
        Given an integer array nums and two integers left and right, return the number of contiguous non-empty subarrays such that the value of the maximum array element in that subarray is in the range [left, right].

        The test cases are generated so that the answer will fit in a 32-bit integer.



        Example 1:

        Input: nums = [2,1,4,3], left = 2, right = 3
        Output: 3
        Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
        Example 2:

        Input: nums = [2,9,2,5,6], left = 2, right = 8
        Output: 7


        Constraints:

        1 <= nums.length <= 105
        0 <= nums[i] <= 109
        0 <= left <= right <= 109*/

public class NumberOfSubArrayWithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int res = 0, prevc = 0, si = 0, ei = 0;
        while (ei < nums.length) {
            //case 1: if nums[ei] is in between left & right
            //we calculate no. of sub-arrays by formulla ei-s1+1;
            //we maintain previous count because in case 2 it helps as in case of 2 we just increment our ans by prevc
            //case 3 is breakpoint basically we reset things here
            if (nums[ei] >= left && nums[ei] <= right) {
                System.out.println(si + "-" + ei);
                prevc = ei - si + 1;
                res += prevc;
            } else if (nums[ei] < left) {
                res += prevc;
            } else {
                si = ei + 1;
                prevc = 0;
            }
            ei++;
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOfSubArrayWithBoundedMaximum n = new NumberOfSubArrayWithBoundedMaximum();
        int nums[] = {2, 1, 4, 3};
        int nums1[] = {2, 9, 2, 5, 6};
        //System.out.println(n.numSubarrayBoundedMax(nums, 2, 3));
        System.out.println(n.numSubarrayBoundedMax(nums1, 2, 8));
    }
}