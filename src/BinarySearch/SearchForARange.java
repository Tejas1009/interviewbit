package BinarySearch;

import java.util.ArrayList;
import java.util.List;

/*Search for a Range
        Asked in:
        Google
        Microsoft
        Given a sorted array of integers A(0 based index) of size N, find the starting and ending position of a given integar B in array A.

        Your algorithm’s runtime complexity must be in the order of O(log n).

        Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].



        Input Format

        The first argument given is the integer array A.
        The second argument given is the integer B.
        Output Format

        Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].
        Constraints

        1 <= N <= 10^6
        1 <= A[i], B <= 10^9
        For Example

        Input 1:
        A = [5, 7, 7, 8, 8, 10]
        B = 8
        Output 1:
        [3, 4]
        Explanation 1:
        First occurence of 8 in A is at index 3
        Second occurence of 8 in A is at index 4
        ans = [3, 4]

        Input 2:
        A = [5, 17, 100, 111]
        B = 3
        Output 2:
        [-1, -1]*/
public class SearchForARange {
    public int[] searchRange(final int[] arr, int B) {
        int[] res = {-1, -1};
        int low = 0, hi = arr.length - 1;
        while (low <= hi) {
            int mid = (hi + low) / 2;
            if ((mid == 0 && arr[mid] == B) || (arr[mid] == B && arr[mid - 1] < B)) {
                res[0] = mid;
                break;
            }
            if (arr[mid] < B) {
                low = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        hi = arr.length - 1;
        while (low <= hi) {
            int mid = (low + hi) / 2;
            if ((mid == arr.length - 1 && arr[mid] == B) || (arr[mid] == B && arr[mid + 1] > B)) {
                res[1] = mid;
                break;
            }
            if (arr[mid] <= B) {
                low = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SearchForARange s = new SearchForARange();
        int arr[] = {5, 7, 7, 8, 8, 8};
        int B = 8;
        System.out.println(s.searchRange(arr, B));
    }
}
