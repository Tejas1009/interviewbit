package TwoPointer;

public class MaxContinous1s {
    /*    You are given with an array of 1s and 0s. And you are given with an integer M, which signifies number of flips allowed.
        Find the position of zeros which when flipped will produce maximum continuous series of 1s.

                For this problem, return the indices of maximum continuous series of 1s in order.

                Example:

        Input :
        Array = {1 1 0 1 1 0 0 1 1 1 }
        M = 1

        Output :
                [0, 1, 2, 3, 4]

        If there are multiple possible solutions, return the sequence which has the minimum start index.*/
    public int[] maxone(int[] arr, int m) {
        int wL = 0, wR = 0, bestWL = 0, bestWindowWidth = -1, nZero = 0;
        while (wR < arr.length) {
            if (nZero <= m) {
                if (arr[wR] == 0) {
                    nZero++;
                }
                wR++;
            }
            if (nZero > m) {
                if (arr[wL] == 0) {
                    nZero--;
                }
                wL++;
            }
            if (bestWindowWidth < wR - wL && (nZero <= m)) {
                bestWindowWidth = wR - wL;
                bestWL = wL;
            }
        }
        int[] ans = new int[bestWindowWidth];
        for (int i = 0; i < bestWindowWidth; i++) {
            ans[i] = bestWL + i;
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxContinous1s m = new MaxContinous1s();
        int arr[] = {1, 1, 0, 1, 1, 0, 0, 1, 1, 1};
        m.maxone(arr, 1);
    }
}
