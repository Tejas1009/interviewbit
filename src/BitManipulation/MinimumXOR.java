package BitManipulation;

import java.util.Arrays;

public class MinimumXOR {
    public int findMinXor(int[] A) {
        int res = Integer.MAX_VALUE;
        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i++) {
            res = Math.min(res, A[i] ^ A[i + 1]);
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumXOR m = new MinimumXOR();
        int arr[] = {15, 5, 1, 10, 2};
        m.findMinXor(arr);
    }
}
