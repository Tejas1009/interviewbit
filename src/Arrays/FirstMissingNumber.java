package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstMissingNumber {
    static int segregate(int arr[], int size) {
        int j = 0, i;
        for (i = 0; i < size; i++) {
            if (arr[i] <= 0) {
                int temp;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

        return j;
    }

    static int findMissingPositive(int arr[], int size) {
        int i;
        for (i = 0; i < size; i++) {
            int x = Math.abs(arr[i]);
            if (x - 1 < size && arr[x - 1] > 0)
                arr[x - 1] = -arr[x - 1];
        }
        for (i = 0; i < size; i++)
            if (arr[i] > 0)
                return i + 1;
        return size + 1;
    }

    static int findMissing(int arr[], int size) {
        int shift = segregate(arr, size);
        int arr2[] = new int[size - shift];
        int j = 0;
        for (int i = shift; i < size; i++) {
            arr2[j] = arr[i];
            j++;
        }
        return findMissingPositive(arr2, j);
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3,4,-1,1));
        int arr_size = A.size();
        int[] ret = new int[arr_size];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = A.get(i);
        }
        int missing = findMissing(ret, arr_size);
        System.out.println(missing);
    }
}
