package Others.Udemy.Recusrion;

/*
Find number of subsets which sums to x.
 */
public class SubSetSumInteger {
    private static int res;

    private static void recur(int arr[], int x, int sum_so_far, int i, String temp) {
        if (sum_so_far > x) return;
        if (sum_so_far == x) {
            res++;
            return;
        }
        if (i > arr.length - 1) return;
        recur(arr, x, sum_so_far + arr[i], i + 1, sum_so_far + "," + arr[i]);
        recur(arr, x, sum_so_far, i + 1, String.valueOf(sum_so_far));
    }

    public static int solve(int arr[], int x) {
        res = 0;
        recur(arr, x, 0, 0, "");
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println(solve(arr, 6));
        System.out.println(solve(arr, 10));
    }
}
