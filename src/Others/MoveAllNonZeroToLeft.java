package Others;
//Move all zeroes to end of array
public class MoveAllNonZeroToLeft {

    public static int[] move(int[] arr) {
        int i = 0, j = 0, n = arr.length;
        while (i < n && j < n) {
            while (i < n && arr[i] != 0) i++;
            j = i;
            while (j < n && arr[j] <= 0) j++;
            if (i < n && j < n) {
                arr[i] = arr[i] ^ arr[j];
                arr[j] = arr[i] ^ arr[j];
                arr[i] = arr[i] ^ arr[j];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 0, 0, 0, 3, 6};
        move(arr);
    }
}
