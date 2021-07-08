package Others.Udemy.Array;

public class MinimumSwapToSort {
    /*
    Given an array of size N, find the minimum number of swaps needed to make an array sorted.
    ip: [5,4,3,2,1]
    op: 2
     */

    //5,4,3,2,1

    //swap1: 1,4,3,2,5
    //swap2: 1,2,3,4,5

    public static int countMinSwaps(int arr[]) {
        int res = 0, i = 0;
        while (i < arr.length) {
            while (i < arr.length && arr[i] != i + 1) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
                res += 1;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {5, 4, 3, 2, 1};
        System.out.println(countMinSwaps(arr));
        int arr1[] = {2, 4, 5, 1, 3};
        System.out.println(countMinSwaps(arr1));
    }
}
