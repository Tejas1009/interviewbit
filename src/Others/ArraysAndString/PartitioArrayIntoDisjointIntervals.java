package Others.ArraysAndString;

/*Given an array nums, partition it into two (contiguous) subarrays left and right so that:

        Every element in left is less than or equal to every element in right.
        left and right are non-empty.
        left has the smallest possible size.
        Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.



        Example 1:

        Input: nums = [5,0,3,8,6]
        Output: 3
        Explanation: left = [5,0,3], right = [8,6]
        Example 2:

        Input: nums = [1,1,1,0,6,12]
        Output: 4
        Explanation: left = [1,1,1,0], right = [6,12]


        Note:

        2 <= nums.length <= 30000
        0 <= nums[i] <= 106
        It is guaranteed there is at least one way to partition nums as described.*/
public class PartitioArrayIntoDisjointIntervals {
    public int partitionDisjoint(int[] nums) {
        //we create a min and max array
        //min will store small elements from end
        //max will store large elements from start
        //while populating large elements if we found any min[i+1] min element which is larger than max[i]
        //then that index is the partition index
        int min[] = new int[nums.length];
        min[nums.length - 1] = nums[nums.length - 1];
        int max[] = new int[nums.length];
        max[0] = nums[0];
        for (int i = nums.length - 2; i >= 0; i--) {
            min[i] = Math.min(min[i + 1], nums[i]);
        }
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(max[i - 1], nums[i]);
            if (max[i] <= min[i + 1]) {
                return i + 1;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        PartitioArrayIntoDisjointIntervals p = new PartitioArrayIntoDisjointIntervals();
        int nums[] = {5, 0, 3, 8, 6};
        System.out.println(p.partitionDisjoint(nums));
        int nums1[] = {1, 1, 1, 0, 6, 12};
        System.out.println(p.partitionDisjoint(nums1));
    }
}
