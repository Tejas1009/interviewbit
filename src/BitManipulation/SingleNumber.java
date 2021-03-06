package BitManipulation;

/*Given an array of integers, every element appears twice except for one. Find that single one.

        Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

        Input Format:

        First and only argument of input contains an integer array A
        Output Format:

        return a single integer denoting single element
        Constraints:

        2 <= N <= 2 000 000
        0 <= A[i] <= INT_MAX*/
public class SingleNumber {
    public int singleNumber(final int[] A) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            res = res ^ A[i];
        }
        return res;
    }

    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();
        int arr[] = {1, 2, 2, 3, 1, 3};
        sn.singleNumber(arr);
    }
}
