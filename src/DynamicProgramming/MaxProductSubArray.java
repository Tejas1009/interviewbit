package DynamicProgramming;

/*Find the contiguous subarray within an array (containing at least one number) which has the largest product.
        Return an integer corresponding to the maximum product possible.

        Example :

        Input : [2, 3, -2, 4]
        Return : 6

        Possible with [2, 3]*/
public class MaxProductSubArray {
    public int maxProduct(int arr[]) {
        int max = arr[0], min = arr[0], res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int curr_max = max;
            max = Math.max(arr[i], Math.max(max * arr[i], min * arr[i]));
            min = Math.min(arr[i], Math.min(curr_max * arr[i], min * arr[i]));
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxProductSubArray m = new MaxProductSubArray();
        int arr[] = {2, 3, -2, 4};
        System.out.println(m.maxProduct(arr));
    }
}