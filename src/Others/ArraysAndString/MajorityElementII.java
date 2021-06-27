package Others.ArraysAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

        Follow-up: Could you solve the problem in linear time and in O(1) space?



        Example 1:

        Input: nums = [3,2,3]
        Output: [3]
        Example 2:

        Input: nums = [1]
        Output: [1]
        Example 3:

        Input: nums = [1,2]
        Output: [1,2]


        Constraints:

        1 <= nums.length <= 5 * 104
        -109 <= nums[i] <= 109*/
public class MajorityElementII {
    //if there are n elements and we need to get all elements that occurs atleast n/3 times
    //then there can be at most 2 elements with occurances of n/3;
    //proof: n%3 where n ranges from 0-2 gives 0, 1 or 2
    //if there are 0 elements remaining then there is no occurance of ay elements of size n/3
    //if there is 1 element remaining then there can be one majority element
    //if there are 2 element remaining then there can be at most 2 majority elements


    //1    2   1   3   2   2   1
    //we need to make triplet
    //we can maintain 2 val's and 2 count's
    //each will count it's corresponding occurances
    //make sure val2 should be any value and count2 should be 0 at start

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int val1 = nums[0], count1 = 1;
        int val2 = nums[0], count2 = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == val1) {
                count1++;
            } else if (nums[i] == val2) {
                count2++;
            } else {
                if (count1 == 0) {
                    val1 = nums[i];
                    count1 = 1;
                } else if (count2 == 0) {
                    val2 = nums[i];
                    count2 = 1;
                } else {
                    count1--;
                    count2--;
                }
            }
        }
        //check if val1 & val2 are greater than n/3
/*        if (count1 > (nums.length / 3)) res.add(val1);
        if (count2 > (nums.length / 3)) res.add(val2);*/
        if (occuredNby3Times(val1, nums)) {
            res.add(val1);
        }
        if (nums.length == 1) return res;
        if (occuredNby3Times(val2, nums)) {
            res.add(val2);
        }
        return res;
    }

    private static boolean occuredNby3Times(int val, int nums[]) {
        long cnt = Arrays.stream(nums).filter(x -> x == val).count();
        return cnt > nums.length / 3;
    }

    public static void main(String[] args) {
        MajorityElementII m = new MajorityElementII();
        int nums[] = {3, 2, 3};
        int nums1[] = {1};
        int nums2[] = {1, 2};
        int nums3[] = {1, 2, 1, 3, 2, 2, 1};
        m.majorityElement(nums).stream().forEach(System.out::println);
        //m.majorityElement(nums1).stream().forEach(System.out::println);
        //m.majorityElement(nums2).stream().forEach(System.out::println);
        //m.majorityElement(nums3).stream().forEach(System.out::println);
    }
}