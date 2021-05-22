package Math;

import java.util.Arrays;

public class NextSimilarNumber {
    public static void main(String[] args) {
        String A = "892795";
        char arr[] = A.toCharArray();
        int i = arr.length - 1;
        /*while (i < arr.length - 1 && (Integer.parseInt(String.valueOf(arr[i - 1])) > Integer.parseInt(String.valueOf(arr[i])))) {
            i--;
        }*/
        for (i = arr.length - 1; i > 0; i--) {
            if (Integer.parseInt(String.valueOf(arr[i - 1])) < Integer.parseInt(String.valueOf(arr[i]))) {
                break;
            }
        }
        if (i == 0) {
            System.out.println(-1);
            return;
        }
        int d = i - 1;
        int swap_idx = d + 1;
        for (int j = d + 1; j < arr.length; j++) {
            final int i1 = Integer.parseInt(String.valueOf(arr[j]));
            if (i1 < arr[swap_idx] && i1 > Integer.parseInt(String.valueOf(arr[d]))) {
                swap_idx = j;
            }
        }
        char temp = arr[swap_idx];
        arr[swap_idx] = arr[d];
        arr[d] = temp;
        Arrays.sort(arr, d + 1, arr.length);
        System.out.println(String.valueOf(arr));
    }
}
