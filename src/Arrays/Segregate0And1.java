package Arrays;

import java.util.Arrays;

public class Segregate0And1 {

    public void segregate(int arr[]) {
        int j = arr.length - 1, i = 0;
        while (i < j) {
            if (arr[i] == 1) {
                arr[i] = arr[i] ^ arr[j];
                arr[j] = arr[i] ^ arr[j];
                arr[i] = arr[i] ^ arr[j];
                j--;
            } else {
                i++;
            }
        }
        Arrays.stream(arr).forEach(System.out::print);
    }

    public static void main(String[] args) {
        Segregate0And1 s = new Segregate0And1();
        int arr[] = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        s.segregate(arr);
    }
}
