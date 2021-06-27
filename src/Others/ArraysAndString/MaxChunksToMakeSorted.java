package Others.ArraysAndString;

/*You are given an integer array arr of length n that represents a permutation of the integers in the range [0, n - 1].

        We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.

        Return the largest number of chunks we can make to sort the array.



        Example 1:

        Input: arr = [4,3,2,1,0]
        Output: 1
        Explanation:
        Splitting into two or more chunks will not return the required result.
        For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
        Example 2:

        Input: arr = [1,0,2,3,4]
        Output: 4
        Explanation:
        We can split into two chunks, such as [1, 0], [2, 3, 4].
        However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.


        Constraints:

        n == arr.length
        1 <= n <= 10
        0 <= arr[i] < n
All the elements of arr are unique.*/
public class MaxChunksToMakeSorted {

    //1    0   2   4   3   5
    //0    1   2   3   4   5
    //     1   2       3   4
    public int maxChunksToSorted(int[] arr) {
        int res = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            if (max == i) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxChunksToMakeSorted m = new MaxChunksToMakeSorted();
        int arr[] = {1, 0, 2, 3, 4};
        int arr1[] = {1, 0, 2, 4, 3, 5};
        int arr2[] = {3, 0, 1, 2, 5, 4, 8, 6, 7};
        System.out.println(m.maxChunksToSorted(arr));
        System.out.println(m.maxChunksToSorted(arr1));
        System.out.println(m.maxChunksToSorted(arr2));
    }
}