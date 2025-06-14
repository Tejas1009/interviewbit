package Arrays;

//https://leetcode.com/problems/find-in-mountain-array/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1095. Find in Mountain Array
 * Hard
 * Topics
 * Companies
 * Hint
 * (This problem is an interactive problem.)
 * <p>
 * You may recall that an array arr is a mountain array if and only if:
 * <p>
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.
 * <p>
 * You cannot access the mountain array directly. You may only access the array using a MountainArray interface:
 * <p>
 * MountainArray.get(k) returns the element of the array at index k (0-indexed).
 * MountainArray.length() returns the length of the array.
 * Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: mountainArr = [1,2,3,4,5,3,1], target = 3
 * Output: 2
 * Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
 * Example 2:
 * <p>
 * Input: mountainArr = [0,1,2,4,2,1], target = 3
 * Output: -1
 * Explanation: 3 does not exist in the array, so we return -1.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= mountainArr.length() <= 104
 * 0 <= target <= 109
 * 0 <= mountainArr.get(index) <= 109
 */
public class FindInMountainArray {
    public static void main(String[] args) {
        MountainArrayImpl mountainArray = new MountainArrayImpl();
        System.out.println(findInMountainArray(81, mountainArray));
    }

    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = getPeakIndex(mountainArr);

        int l = 0, r = peakIndex, result = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            int currentVal = mountainArr.get(m);
            if (target == currentVal) {
                return m;
            } else if (target < currentVal) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        l = peakIndex;
        r = mountainArr.length() - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int currentVal = mountainArr.get(m);
            if (target == currentVal) {
                return m;
            } else if (target > currentVal) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return result;
    }

    private static int getPeakIndex(MountainArray mountainArr) {
        int n = mountainArr.length();
        int l = 1, r = n - 2;
        while (l <= r) {
            int m = (l + r) / 2;
            int currentVal = mountainArr.get(m);
            int prevVal = mountainArr.get(m - 1);
            int nextVal = mountainArr.get(m + 1);
            if (prevVal < currentVal && currentVal < nextVal) {
                l = m + 1;
            } else if (prevVal > currentVal && currentVal > nextVal) {
                r = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }

}

interface MountainArray {
    int get(int index);

    public int length();
}

class MountainArrayImpl implements MountainArray {
    private List<Integer> list;

    public MountainArrayImpl() {
        list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82);
    }

    @Override
    public int get(int index) {
        return list.get(index);
    }

    @Override
    public int length() {
        return list.size();
    }
}
