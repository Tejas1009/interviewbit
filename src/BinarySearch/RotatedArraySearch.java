package BinarySearch;

public class RotatedArraySearch {
    private int arrSearch(int arr[], int B, int low, int hi) {
        if (low > hi) {
            return -1;
        }
        int mid = (hi + low) / 2;
        if (arr[mid] == B) {
            return mid;
        }
        //check if arr is sorted from low to mid
        if (arr[low] <= arr[mid]) {
            if (B <= arr[mid] && B >= arr[low]) {
                return arrSearch(arr, B, low, mid - 1);
            } else {
                return arrSearch(arr, B, mid + 1, hi);
            }
        } else {
            if (B >= arr[mid] && B <= arr[hi]) {
                return arrSearch(arr, B, mid + 1, hi);
            } else {
                return arrSearch(arr, B, low, mid - 1);
            }
        }
    }

    public int search(final int[] arr, int B) {
        return this.arrSearch(arr, B, 0, arr.length - 1);
    }

    /**
     * leetcode
     * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
     */
    public static int searchLeetCode(int[] nums, int target) {
        int result = -1;
        int high = nums.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RotatedArraySearch r = new RotatedArraySearch();
        int arr[] = {5, 1, 3};
        int B = 3;
        //System.out.println(r.search(arr, B));
        System.out.println(searchLeetCode(arr, B));
    }
}
