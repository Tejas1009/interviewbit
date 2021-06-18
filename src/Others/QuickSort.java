package Others;

import java.util.Arrays;

public class QuickSort {
    int arr[];

    //3,7,5,8,1
    //3,1,5,8,7
    //1,3,5,8,7
    private int partition(int l, int h) {
        int pivot = arr[l];
        int pivotIdx = l;
        while (l < h) {
            while (l <= arr.length - 1 && arr[l] <= pivot) l++;
            while (h >= 0 && arr[h] > pivot) h--;
            if (l < h) {
                swap(l, h);
            }
        }
        swap(h, pivotIdx);
        return h;
    }

    private void sort(int l, int h) {
        if (l < h) {
            int pivot = partition(l, h);
            sort(l, pivot - 1);
            sort(pivot + 1, h);
        }
    }

    public void quickSort(int arr[]) {
        this.arr = arr;
        sort(0, arr.length - 1);
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int arr[] = {10, 80, 30, 90, 40, 50, 70};
        q.quickSort(arr);
        Arrays.stream(arr).forEach(x -> System.out.print(x + ","));
    }
}
