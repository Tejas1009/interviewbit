package Others.Udemy.BinarySearch;

public class GameOfGreed {

    //arr: {1,2,3,4} k = 3
    /*
        {1,2}=3
        {3}=3
        {4}=4
     */

    //3
    public static int getCoins(int arr[], int k) {
        int res = 0;
        int e = 0, s = 0;
        for (int i : arr) {
            e += i;
        }
        while (s <= e) {
            int mid = (s + e) / 2;
            boolean possible = isPartitionPossible(s, e, arr, mid, k);
            if (possible) {
                res = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return res;
    }

    private static boolean isPartitionPossible(int s, int e, int[] arr, int mid, int k) {
        int curr_sum = 0, res = 0;
        for (int i = 0; i < arr.length; i++) {
            curr_sum += arr[i];
            if (curr_sum >= mid) {
                res++;
                curr_sum = 0;
            }
            if (k == res) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        System.out.println(getCoins(arr, 3));
    }
}
