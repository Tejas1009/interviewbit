package Others;

import java.util.Arrays;

public class ReverseArrayByKElement {
    int arr[];

    private void reverse(int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public void reverseKElement(int[] arr, int k) {
        this.arr = arr;
        k = k % arr.length;
        if (k == 0) {
            System.out.println(arr);
            return;
        }
        if (k < 0) {
            k = arr.length + k;
        }
        //part 1:
        reverse(0, arr.length - k - 1);
        //part 2:
        reverse(arr.length - k, arr.length - 1);
        //reverse whole string
        reverse(0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::print);
    }

    public static void main(String[] args) {
        ReverseArrayByKElement r = new ReverseArrayByKElement();
        int arr[] = {1, 2, 3, 4, 5};
        r.reverseKElement(arr, 2);
    }
}
