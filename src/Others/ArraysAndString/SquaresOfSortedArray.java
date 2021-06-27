package Others.ArraysAndString;

import java.util.Arrays;

/*Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.



        Example 1:

        Input: nums = [-4,-1,0,3,10]
        Output: [0,1,9,16,100]
        Explanation: After squaring, the array becomes [16,1,0,9,100].
        After sorting, it becomes [0,1,9,16,100].
        Example 2:

        Input: nums = [-7,-3,2,3,11]
        Output: [4,9,9,49,121]


        Constraints:

        1 <= nums.length <= 104
        -104 <= nums[i] <= 104
        nums is sorted in non-decreasing order.


        Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?*/
public class SquaresOfSortedArray {
    //Input:  [-7,-3,2,3,11]
    //Output: [4,9,9,49,121]
    public int[] sortedSquares(int[] nums) {
        int res[] = new int[nums.length];
        int i = 0, j = nums.length - 1, k = nums.length - 1;
        //find biggest abs number
        //if nums[i] is greater than nums[j] i++ else j--;
        //get square of it add it to res[end]
        //continue till i < j

        //-7, -3, 2, 3, 11
        //i             j  -> 11
        //i          j     -> 7
        //      i    j     -> 3
        //         i j     -> 3
        //         i,j
        while (i <= j) {
            int curr = Math.abs(nums[j]);
            if (Math.abs(nums[i]) >= Math.abs(nums[j])) {
                curr = Math.abs(nums[i]);
                i++;
                res[k--] = curr * curr;
                continue;
            }
            res[k--] = curr * curr;
            j--;
        }
        return res;
    }

    public static void main(String[] args) {
        SquaresOfSortedArray s = new SquaresOfSortedArray();
        int nums[] = {-7, -3, 2, 3, 11};
        int nums1[] = {-4, -1, 0, 3, 10};
        int res[] = s.sortedSquares(nums1);
        Arrays.stream(res).forEach(System.out::println);
    }
}