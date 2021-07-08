package Others.Udemy.Array;

import java.util.ArrayList;
import java.util.Arrays;

public class SubArraySort {

    //given a array wherein a part of subarray is not sorted
    //we need to return the starting and ending index of the array of the sub-array
    //which are not sorted
    //if array is already sorted return -1,-1

    //ip: 1,2,3,4,5,8,6,7,9,10,11
    //op: 5,7
    public static ArrayList<ArrayList<Integer>> subArraySort(int arr[]) {
        //we will find smallest and largest numbers which are not at there position
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (isOutOfOrder(arr, i)) {
                smallest = Math.min(smallest, arr[i]);
                largest = Math.max(largest, arr[i]);
            }
        }
        if (smallest == Integer.MAX_VALUE) {
            res.add(new ArrayList<>(Arrays.asList(-1, -1)));
            return res;
        }
        int left = 0;
        while (smallest >= arr[left]) left++;
        int right = arr.length - 1;
        while (largest <= arr[right]) right--;
        res.add(new ArrayList<>(Arrays.asList(left, right)));
        return res;
    }

    private static boolean isOutOfOrder(int arr[], int i) {
        int x = arr[i];
        if (i == 0 && x > arr[1]) {
            return true;
        }
        if (i == arr.length - 1 && x < arr[i - 1]) {
            return true;
        }
        return (i > 0) && (i < arr.length - 1) && (x > arr[i + 1] || x < arr[i - 1]);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11};
        subArraySort(arr).forEach(System.out::print);
        System.out.println();
        int arr1[] = {1, 2, 3, 4, 5, 6, 9, 7, 9, 10, 11};
        subArraySort(arr1).forEach(System.out::print);
    }
}
