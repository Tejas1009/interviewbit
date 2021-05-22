package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;

/*Remove duplicates from Sorted Array
        Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.

        Note that even though we want you to return the new length, make sure to change the original array as well in place

        Do not allocate extra space for another array, you must do this in place with constant memory.

        Example:
        Given input array A = [1,1,2],
         Your function should return length = 2, and A is now [1,2].*/
public class RemoveDupesFromSortedArray {
    public int removeDuplicates(ArrayList<Integer> nums) {
        int k = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (i < nums.size() - 1 && nums.get(i).intValue() == nums.get(i + 1).intValue()) {
                continue;
            }
            nums.set(k, nums.get(i));
            k++;
        }
        return k;
    }

    public static void main(String[] args) {
        RemoveDupesFromSortedArray r = new RemoveDupesFromSortedArray();
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5000, 5000, 5000));
        int d = r.removeDuplicates(arr);
        for (int i = d; i < arr.size(); i++) {
            arr.remove(i);
            i--;
        }
        System.out.println(arr);
    }
}
