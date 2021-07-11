package Others.Udemy.SortAndSearch;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    private static void merge(int arr[], int s, int e) {
        int i = s, m = (s + e) / 2, j = m + 1;
        ArrayList<Integer> temp = new ArrayList<>();
        while (i <= m && j <= e) {
            if (arr[i] < arr[j]) {
                temp.add(arr[i++]);
            } else {
                temp.add(arr[j++]);
            }
        }
        while (i <= m) {
            temp.add(arr[i++]);
        }
        while (j <= e) {
            temp.add(arr[j++]);
        }
        int k = 0;
        for (int x = s; x <= e; x++) {
            arr[x] = temp.get(k++);
        }
    }

    public static void mergeSort(int arr[], int s, int e) {
        if (s >= e) {
            return;
        }
        int mid = (s + e) / 2;
        mergeSort(arr, s, mid);
        mergeSort(arr, mid + 1, e);
        merge(arr, s, e);
    }

    public static void main(String[] args) {
        int arr[] = {10, 5, 2, 7, 6, 4, 0};
        mergeSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();
    }
}